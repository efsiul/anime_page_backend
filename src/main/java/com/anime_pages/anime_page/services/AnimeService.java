package com.anime_pages.anime_page.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.anime_pages.anime_page.interfaces.InterfaceAnimeService;
import com.anime_pages.anime_page.models.AnimeDetailsModels;
import com.anime_pages.anime_page.models.dtos.AnimeDetailsDTO;
import com.anime_pages.anime_page.models.dtos.AnimeResponseDTO;
import com.anime_pages.anime_page.models.dtos.AverageScoreByTypeSeasonDTO;
import com.anime_pages.anime_page.repositories.IAnimeRepository;
import com.anime_pages.anime_page.services.mapper.AnimeMapper;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AnimeService implements InterfaceAnimeService {
    
    @Autowired
    private IAnimeRepository animeRepository;

    @Value("${jikan.api.url}")
    private String jikanApiUrl; 

    private WebClient webClient;
    private final ModelMapper modelMapper; 

    private String lastSearchedType;
    private StringBuilder searchResult;
    private String lastSearchedTitle;

    public AnimeService(WebClient webClient, IAnimeRepository animeRepository, ModelMapper modelMapper) {
        this.webClient = webClient;
        this.modelMapper = modelMapper;
        this.animeRepository = animeRepository; 
    }

    @Override
    public Flux<AnimeDetailsDTO> searchAnimeTitle(String title) {        String formattedTitle = title.replace(" ", "%20");
        String apiUrl = jikanApiUrl + "/anime?q=" + formattedTitle + "&sfw=true&exact=true";

        // String apiResponse = webClient.get()
        // .uri(apiUrl)
        // .retrieve()
        // .bodyToMono(String.class)
        // .block();

        // System.out.println("API Response: " + apiResponse);
        return webClient.get()
        .uri(apiUrl)
        .retrieve()
        .bodyToMono(AnimeResponseDTO.class)
        .flatMapMany(animeResponse -> {
            List<AnimeDetailsDTO> animeDetailsDTOs = new ArrayList<>();
            if (animeResponse != null && animeResponse.getAnimes() != null) {
                animeDetailsDTOs = animeResponse.getAnimes().stream()
                        .map(AnimeMapper::mapToAnimeDetailsDTO)
                        .collect(Collectors.toList());

                Flux<AnimeDetailsDTO> fluxAnimeDetailsDTO = Flux.fromIterable(animeDetailsDTOs);

                // Save the results to the database
                saveAnimeDetailsToDatabase(animeDetailsDTOs);
                saveAnimeDetailsToSearchResult(animeDetailsDTOs);
                lastSearchedType = animeDetailsDTOs.isEmpty() ? null : animeDetailsDTOs.get(0).getType();
                lastSearchedTitle = title;

                return fluxAnimeDetailsDTO;
            } else {
                System.out.println("No se encontraron resultados para la búsqueda: " + title);
                return Flux.empty();
            }
        });
    }

    private void saveAnimeDetailsToSearchResult(List<AnimeDetailsDTO> animeDetailsDTOs) {
        if (searchResult == null) {
            searchResult = new StringBuilder();
        }

        animeDetailsDTOs.forEach(animeDetailsDTO -> {
            searchResult.append(animeDetailsDTO.getTitle()).append(",");
        });
    }

    @Override
    public List<AverageScoreByTypeSeasonDTO> averageScoreByTypeSeason() {
        if (searchResult == null) {
            System.out.println("Realiza una búsqueda antes de calcular el promedio.");
            return Collections.emptyList();
        }


        // Get all anime entries
        String searchResultString = searchResult.toString();

        List<AnimeDetailsModels> animeDetailsModelsList = convertStringToAnimeDetailsList(searchResultString);

        // Calculate the average score by type and season
        List<AverageScoreByTypeSeasonDTO> averageScores = calculateAverageScore(lastSearchedTitle, animeDetailsModelsList);
    
        // Create a list to store the final result
        List<AverageScoreByTypeSeasonDTO> result = new ArrayList<>();
    
        // Add the title and type information to each entry
        for (AverageScoreByTypeSeasonDTO averageScore : averageScores) {
            result.add(new AverageScoreByTypeSeasonDTO(lastSearchedTitle, averageScore.getType(), averageScore.getAverage()));
        }
    
        System.out.println("Average Score by Type and Season:");
        averageScores.forEach(System.out::println);
    
        return result;
    }

    private List<AnimeDetailsModels> convertStringToAnimeDetailsList(String searchResultString) {

        String[] titles = searchResultString.split(",");
    
        // Filtrar títulos no vacíos y obtener las correspondientes entradas desde la base de datos
        return Arrays.stream(titles)
                .filter(title -> !title.isEmpty())
                .map(title -> animeRepository.findByTitle(title))
                .filter(Objects::nonNull)
                .flatMap(List::stream)  // Utilizar flatMap para aplanar la lista de listas
                .collect(Collectors.toList());
    }

    private List<AverageScoreByTypeSeasonDTO> calculateAverageScore(String title, List<AnimeDetailsModels> animeDetailsModelsList) {
        if (animeDetailsModelsList == null || animeDetailsModelsList.isEmpty()) {
            // Handle empty or null list as needed
            return Collections.emptyList();
        }
    
        // Filter null elements
        List<AnimeDetailsModels> nonNullAnimeList = animeDetailsModelsList.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    
        // Filter elements with null score
        List<AnimeDetailsModels> nonNullScoreList = nonNullAnimeList.stream()
                .filter(anime -> anime.getScore() != null)
                .collect(Collectors.toList());
    
        // Group by type (type) and calculate the average score for each group
        Map<String, Double> averageScoresByType = nonNullScoreList.stream()
                .collect(Collectors.groupingBy(AnimeDetailsModels::getType,
                        Collectors.averagingDouble(AnimeDetailsModels::getScore)));
    
        // Create the list of AverageScoreByTypeSeason
        return averageScoresByType.entrySet().stream()
                .map(entry -> new AverageScoreByTypeSeasonDTO(title, entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }


    private void saveAnimeDetailsToDatabase(List<AnimeDetailsDTO> animeDetailsDTOs) {
        if (animeDetailsDTOs == null || animeDetailsDTOs.isEmpty()) {
            return;
        }
    
        List<AnimeDetailsModels> animeDetailsModelsList = new ArrayList<>();
    
        for (AnimeDetailsDTO animeDetailsDTO : animeDetailsDTOs) {
            AnimeDetailsModels existingAnime = animeRepository.findByTitleOrMalid(animeDetailsDTO.getTitle(), animeDetailsDTO.getMal_id());
    
            if (existingAnime == null) {
                AnimeDetailsModels animeDetailsModel = modelMapper.map(animeDetailsDTO, AnimeDetailsModels.class);
                animeDetailsModelsList.add(animeDetailsModel);
            }
        }
    
        animeRepository.saveAll(animeDetailsModelsList);
    }
}
