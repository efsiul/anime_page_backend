package com.anime_pages.anime_page.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.anime_pages.anime_page.interfaces.InterfaceAnimeService;
import com.anime_pages.anime_page.models.AnimeDetailsModels;
import com.anime_pages.anime_page.models.dtos.Anime;
import com.anime_pages.anime_page.models.dtos.AnimeDetailsDTO;
import com.anime_pages.anime_page.models.dtos.AnimeResponse;
import com.anime_pages.anime_page.repositories.IAnimeRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AnimeService implements InterfaceAnimeService {
    
    @Autowired
    private IAnimeRepository animeRepository;

    @Value("${jikan.api.url}")
    private String jikanApiUrl; 

    private RestTemplate restTemplate;

    public AnimeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<AnimeDetailsDTO> searchAnimeTitle(String title) {
        String apiUrl = jikanApiUrl + "/anime?q=" + title + "&sfw";


        String apiResponse = restTemplate.getForObject(apiUrl, String.class);
        System.out.println("API Response: " + apiResponse);
        try {
            ResponseEntity<AnimeResponse> response = restTemplate.getForEntity(apiUrl, AnimeResponse.class);
            AnimeResponse animeResponse = response.getBody();

            List<AnimeDetailsDTO> animeDetailsDTOs = new ArrayList<>();
            System.out.println("$$$$$$$$$$$$$$$ API animeResponse es: " + animeResponse);

            if (animeResponse != null && animeResponse.getAnimes() != null) {
                for (Anime anime : animeResponse.getAnimes()) {
                    AnimeDetailsDTO animeDetailsDTO = new AnimeDetailsDTO();

                    animeDetailsDTO.setMalId(anime.getMalId());
                    animeDetailsDTO.setUrl(anime.getUrl());
                    animeDetailsDTO.setTitle(anime.getTitle());
                    animeDetailsDTO.setType(anime.getType());
                    animeDetailsDTO.setSource(anime.getSource());
                    animeDetailsDTO.setEpisodes(anime.getEpisodes());
                    animeDetailsDTO.setStatus(anime.getStatus());
                    animeDetailsDTO.setDuration(anime.getDuration());
                    animeDetailsDTO.setRating(anime.getRating());
                    animeDetailsDTO.setRank(anime.getRank());
                    animeDetailsDTO.setPopularity(anime.getPopularity());
                    animeDetailsDTO.setScore(anime.getScore());

                    animeDetailsDTOs.add(animeDetailsDTO);
                }
            }
            System.out.println("$$$$$$$$$$$$$$$ API animeDetailsDTOs es: " + animeDetailsDTOs);

            return animeDetailsDTOs;
  
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return Collections.emptyList();
    }

    private AnimeDetailsModels mapToAnimeDetailsModels(AnimeDetailsDTO animeDetailsDTO) {

        System.out.println("AnimeDetailsDTO: " + animeDetailsDTO);

        AnimeDetailsModels animeDetailsModels = new AnimeDetailsModels();
        animeDetailsModels.setMalId(animeDetailsDTO.getMalId());
        animeDetailsModels.setUrl(animeDetailsDTO.getUrl());
        animeDetailsModels.setTitle(animeDetailsDTO.getTitle());
        animeDetailsModels.setType(animeDetailsDTO.getType());
        animeDetailsModels.setSource(animeDetailsDTO.getSource());
        animeDetailsModels.setEpisodes(animeDetailsDTO.getEpisodes());
        animeDetailsModels.setStatus(animeDetailsDTO.getStatus());
        animeDetailsModels.setDuration(animeDetailsDTO.getDuration());
        animeDetailsModels.setRating(animeDetailsDTO.getRating());
        animeDetailsModels.setRank(animeDetailsDTO.getRank());
        animeDetailsModels.setPopularity(animeDetailsDTO.getPopularity());
        animeDetailsModels.setScore(animeDetailsDTO.getScore());
        animeDetailsModels.setSynopsis(animeDetailsDTO.getSynopsis());

        return animeDetailsModels;
    }
}
