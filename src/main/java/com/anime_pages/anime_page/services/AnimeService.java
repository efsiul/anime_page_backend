package com.anime_pages.anime_page.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import com.anime_pages.anime_page.interfaces.InterfaceAnimeService;
import com.anime_pages.anime_page.models.AnimeDetailsModels;
import com.anime_pages.anime_page.models.dtos.AnimeDTO;
import com.anime_pages.anime_page.models.dtos.AnimeDetailsDTO;
import com.anime_pages.anime_page.models.dtos.AnimeResponseDTO;
import com.anime_pages.anime_page.models.dtos.AverageScoreByTypeSeasonDTO;
import com.anime_pages.anime_page.repositories.IAnimeRepository;
import com.anime_pages.anime_page.services.mapper.AnimeMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnimeService implements InterfaceAnimeService {
    
    @Autowired
    private IAnimeRepository animeRepository;

    @Value("${jikan.api.url}")
    private String jikanApiUrl; 

    private WebClient webClient;
    private final ModelMapper modelMapper; 

    public AnimeService(WebClient webClient, ModelMapper modelMapper, IAnimeRepository animeRepository) {
        this.webClient = webClient;
        this.modelMapper = modelMapper;
        this.animeRepository = animeRepository; 
    }
    @Override
    public List<AnimeDetailsDTO> searchAnimeTitle(String title) {
        String formattedTitle = title.replace(" ", "%20");
        String apiUrl = jikanApiUrl + "/anime?q=" + title + formattedTitle + "&sfw&exact=true";


        try {

            return webClient.get()
                    .uri(apiUrl)
                    .retrieve()
                    .bodyToMono(AnimeResponseDTO.class)
                    .map(animeResponse -> {
                        List<AnimeDetailsDTO> animeDetailsDTOs = new ArrayList<>();
                        if (animeResponse != null && animeResponse.getAnimes() != null) {
                            for (AnimeDTO anime : animeResponse.getAnimes()) {
                                AnimeDetailsDTO animeDetailsDTO = AnimeMapper.mapToAnimeDetailsDTO(anime);

                                if (!animeRepository.existsByTitle(animeDetailsDTO.getTitle())) {
                                    AnimeDetailsModels animeDetailsModels = modelMapper.map(animeDetailsDTO, AnimeDetailsModels.class);
                                    animeRepository.save(animeDetailsModels);
                                }

                                animeDetailsDTOs.add(animeDetailsDTO);
                            }
                        }
    
                        return animeDetailsDTOs;
                    })
                    .block();
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return Collections.emptyList();
    }

    @Override
    public List<AverageScoreByTypeSeasonDTO> averageScoreByTypeSeason() {
        // Obtener todas las entradas de anime
        List<AnimeDetailsModels> allAnimeEntries = animeRepository.findAll();

        // Agrupar por tipo (type) y calcular el promedio de score para cada grupo
        Map<String, Double> averageScoresByType = allAnimeEntries.stream()
                .collect(Collectors.groupingBy(AnimeDetailsModels::getType,
                        Collectors.averagingDouble(AnimeDetailsModels::getScore)));

        // Crear la lista de AverageScoreByTypeSeason
        List<AverageScoreByTypeSeasonDTO> result = averageScoresByType.entrySet().stream()
                .map(entry -> new AverageScoreByTypeSeasonDTO(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        return result;
    }
}
