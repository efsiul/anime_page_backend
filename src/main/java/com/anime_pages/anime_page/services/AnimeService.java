package com.anime_pages.anime_page.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import com.anime_pages.anime_page.interfaces.InterfaceAnimeService;
import com.anime_pages.anime_page.models.AnimeDetailsModels;
import com.anime_pages.anime_page.models.dtos.Anime;
import com.anime_pages.anime_page.models.dtos.AnimeDetailsDTO;
import com.anime_pages.anime_page.models.dtos.AnimeResponse;
import com.anime_pages.anime_page.repositories.IAnimeRepository;
import com.anime_pages.anime_page.services.mapper.AnimeMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AnimeService implements InterfaceAnimeService {
    
    @Autowired
    private IAnimeRepository animeRepository;

    @Value("${jikan.api.url}")
    private String jikanApiUrl; 

    private WebClient webClient;

    public AnimeService(WebClient webClient) {
        this.webClient = webClient;
    }
    @Override
    public List<AnimeDetailsDTO> searchAnimeTitle(String title) {
        String apiUrl = jikanApiUrl + "/anime?q=" + title + "&sfw";


        try {

            return webClient.get()
                    .uri(apiUrl)
                    .retrieve()
                    .bodyToMono(AnimeResponse.class)
                    .map(animeResponse -> {
                        List<AnimeDetailsDTO> animeDetailsDTOs = new ArrayList<>();
                        if (animeResponse != null && animeResponse.getAnimes() != null) {
                            for (Anime anime : animeResponse.getAnimes()) {
                                animeDetailsDTOs.add(AnimeMapper.mapToAnimeDetailsDTO(anime));
                            }
                        }
    
                        System.out.println("### animeDetailsDTOs: " + animeDetailsDTOs);
    
                        return animeDetailsDTOs;
                    })
                    .block();
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return Collections.emptyList();
    }
}
