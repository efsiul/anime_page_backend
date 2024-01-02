package com.anime_pages.anime_page.models.dtos;

import lombok.Data;

@Data
public class Anime {

    private Long malId;

    private String url;

    private String title;

    private String type;

    private String source;

    private Integer episodes;

    private String status;

    private String duration;

    private String rating;

    private Integer rank;

    private Integer popularity;

    private Double score;

}