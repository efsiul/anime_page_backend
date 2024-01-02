package com.anime_pages.anime_page.models.dtos;

import java.util.List;

import lombok.Data;

@Data
public class AnimeResponse {

    private Boolean success;

    private String message;

    private List<Anime> animes;

}