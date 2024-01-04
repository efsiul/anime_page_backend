package com.anime_pages.anime_page.models.dtos;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AnimeResponseDTO {

    private Boolean success;

    private String message;

    @JsonProperty("data")
    private List<AnimeDTO> animes;

}