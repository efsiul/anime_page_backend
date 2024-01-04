package com.anime_pages.anime_page.Controllers;


import java.util.List;
import com.anime_pages.anime_page.interfaces.InterfaceAnimeService;
import com.anime_pages.anime_page.models.dtos.AnimeDetailsDTO;
import com.anime_pages.anime_page.models.dtos.AverageScoreByTypeSeasonDTO;
import reactor.core.publisher.Flux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/anime")
@CrossOrigin(origins = "http://localhost:3000")
public class AnimeController {

    private final InterfaceAnimeService animeService;

    @Autowired
    public AnimeController(InterfaceAnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping("/search")
    public ResponseEntity<Flux<AnimeDetailsDTO>> searchAnimeTitle(@RequestParam String title) {
        Flux<AnimeDetailsDTO> animeFlux = animeService.searchAnimeTitle(title);
        return ResponseEntity.ok(animeFlux);
    }

    @GetMapping("/averageScoreByTypeSeason")
    public ResponseEntity<Flux<AverageScoreByTypeSeasonDTO>> averageScoreByTypeSeason() {
        List<AverageScoreByTypeSeasonDTO> averageScores = animeService.averageScoreByTypeSeason();
        Flux<AverageScoreByTypeSeasonDTO> averageScoresFlux = Flux.fromIterable(averageScores);
        return ResponseEntity.ok(averageScoresFlux);
    }

}