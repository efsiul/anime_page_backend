package com.anime_pages.anime_page.models.dtos;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AnimeDetailsDTO {

    private Long id;

    @JsonProperty("malId")
    private Long malId;

    @JsonProperty("url")
    private String url;

    @JsonProperty("title")
    private String title;

    @JsonProperty("type")
    private String type;

    @JsonProperty("source")
    private String source;

    @JsonProperty("episodes")
    private Integer episodes;

    @JsonProperty("status")
    private String status;

    @JsonProperty("duration")
    private String duration;

    @JsonProperty("rating")
    private String rating;

    @JsonProperty("rank")
    private Integer rank;

    @JsonProperty("popularity")
    private Integer popularity;

    @JsonProperty("score")
    private Double score;

    @JsonProperty("synopsis")
    private String synopsis;

    @JsonProperty("animes")
    private List<AnimeDetailsDTO> animes;

}
