package com.anime_pages.anime_page.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.anime_pages.anime_page.interfaces.InterfaceAnimeService;
import com.anime_pages.anime_page.models.dtos.AnimeDetailsDTO;
import java.util.List;

@Service
public class AnimeService implements InterfaceAnimeService {

    @Value("${jikan.api.url}")
    private String jikanApiUrl; // URL de la API de Jikan

    private final RestTemplate restTemplate;

    public AnimeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public AnimeDetailsDTO searchAnimeTitle(String title) {
        // Lógica para buscar un título de anime por nombre
        // Puedes implementar esto según tu necesidad y acceso a datos
        return null;
    }

    @Override
    public List<AnimeDetailsDTO> listTopAnimeTitles() {
        // Lógica para listar al menos 5 títulos en un control deslizante
        // Puedes implementar esto según tu necesidad y acceso a datos
        return null;
    }

    @Override
    public AnimeDetailsDTO getAnimeDetailsFromApi(String malId) {
        // Lógica para consumir la API de Animes (Jikan) y obtener detalles
        String apiUrl = jikanApiUrl + "/anime/" + malId;
        return restTemplate.getForObject(apiUrl, AnimeDetailsDTO.class);
    }

    @Override
    public Double calculateAverageScore(List<AnimeDetailsDTO> animeDetailsList) {
        // Lógica para calcular la puntuación promedio de todas las temporadas del anime
        // Puedes implementar esto según tu necesidad
        double sum = 0;
        for (AnimeDetailsDTO animeDetails : animeDetailsList) {
            sum += animeDetails.getScore();
        }
        return sum / animeDetailsList.size();
    }

    @Override
    public String getRecommendationMessage(Double score) {
        // Lógica para aplicar la regla de negocio y obtener un mensaje según la puntuación
        if (score >= 1 && score <= 4) {
            return "No lo recomiendo.";
        } else if (score >= 5 && score <= 7) {
            return "Puedes divertirte.";
        } else {
            return "Genial, este es uno de los mejores animes.";
        }
    }
}
