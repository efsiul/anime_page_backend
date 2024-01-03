package com.anime_pages.anime_page.interfaces;


import java.util.List;

import com.anime_pages.anime_page.models.dtos.AnimeDetailsDTO;
import com.anime_pages.anime_page.models.dtos.AverageScoreByTypeSeasonDTO;

import reactor.core.publisher.Flux;

public interface InterfaceAnimeService {

    // Método para buscar un título de anime
    Flux<AnimeDetailsDTO> searchAnimeTitle(String title);
    
    List<AverageScoreByTypeSeasonDTO> averageScoreByTypeSeason();    
    

}