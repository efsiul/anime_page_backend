package com.anime_pages.anime_page.models.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AnimeResponse {

    private Boolean success;

    private String message;

    @JsonProperty("data")
    private List<Anime> animes;

}