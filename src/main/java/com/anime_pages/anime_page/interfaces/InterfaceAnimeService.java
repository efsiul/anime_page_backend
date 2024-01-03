package com.anime_pages.anime_page.interfaces;


import java.util.List;

import com.anime_pages.anime_page.models.dtos.AnimeDetailsDTO;
import com.anime_pages.anime_page.models.dtos.AverageScoreByTypeSeasonDTO;

public interface InterfaceAnimeService {

    // Método para buscar un título de anime
    List<AnimeDetailsDTO> searchAnimeTitle(String title);
    
     List<AverageScoreByTypeSeasonDTO> averageScoreByTypeSeason();
    
    
    // AnimeDetailsDTO searchAnimeTitle(String title);

    // // Método para listar al menos 5 títulos en un control deslizante
    // List<AnimeDetailsDTO> listTopAnimeTitles();

    // // Método para consumir la API de Animes y obtener detalles
    // AnimeDetailsDTO getAnimeDetailsFromApi(String malId);

    // // Método para calcular la puntuación promedio de todas las temporadas del anime
    // Double calculateAverageScore(List<AnimeDetailsDTO> animeDetailsList);

    // // Método para aplicar la regla de negocio y obtener un mensaje según la puntuación
    // String getRecommendationMessage(Double score);
}