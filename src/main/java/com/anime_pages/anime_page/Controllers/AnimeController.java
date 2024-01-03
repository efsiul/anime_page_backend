package com.anime_pages.anime_page.Controllers;


import java.util.List;
import com.anime_pages.anime_page.interfaces.InterfaceAnimeService;
import com.anime_pages.anime_page.models.dtos.AnimeDetailsDTO;

import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<AnimeDetailsDTO>> searchAnimeTitle(@RequestParam String title) {
        List<AnimeDetailsDTO> animeList = animeService.searchAnimeTitle(title);
        return ResponseEntity.ok(animeList);
    }

}