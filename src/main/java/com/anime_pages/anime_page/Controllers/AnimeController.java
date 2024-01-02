package com.anime_pages.anime_page.Controllers;


import java.util.List;
import com.anime_pages.anime_page.interfaces.InterfaceAnimeService;
import com.anime_pages.anime_page.models.dtos.AnimeDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/anime")
public class AnimeController {

    private final InterfaceAnimeService animeService;

    @Autowired
    public AnimeController(InterfaceAnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping("/search")
    public List<AnimeDetailsDTO> searchAnimeTitle(@RequestParam String title) {
        return animeService.searchAnimeTitle(title);
    }


    // Endpoint para buscar un título de anime
    // @GetMapping("/search")
    // public AnimeDetailsDTO searchAnimeTitle(@RequestParam String title) {
    //     return animeService.searchAnimeTitle(title);
    // }

    // // Endpoint para listar al menos 5 títulos en un control deslizante
    // @GetMapping("/top")
    // public List<AnimeDetailsDTO> listTopAnimeTitles() {
    //     return animeService.listTopAnimeTitles();
    // }

    // // Endpoint para obtener detalles de un anime por su ID
    // @GetMapping("/{malId}")
    // public AnimeDetailsDTO getAnimeDetails(@PathVariable String malId) {
    //     return animeService.getAnimeDetailsFromApi(malId);
    // }

    // // Endpoint para calcular la puntuación promedio de todas las temporadas del anime
    // @GetMapping("/averageScore")
    // public Double calculateAverageScore(@RequestParam List<String> malIds) {
    //     // Puedes obtener la lista de animes desde el servicio o cualquier otra fuente
    //     List<AnimeDetailsDTO> animeDetailsList = malIds.stream()
    //             .map(animeService::getAnimeDetailsFromApi)
    //             .collect(Collectors.toList());

    //     return animeService.calculateAverageScore(animeDetailsList);
    // }

    // // Endpoint para obtener el mensaje de recomendación según la puntuación
    // @GetMapping("/recommendationMessage/{score}")
    // public String getRecommendationMessage(@PathVariable Double score) {
    //     return animeService.getRecommendationMessage(score);
    // }
}