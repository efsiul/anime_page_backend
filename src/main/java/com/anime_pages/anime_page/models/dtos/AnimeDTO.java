package com.anime_pages.anime_page.models.dtos;

import lombok.Data;

@Data
public class AnimeDTO {

    private Integer mal_id;

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

    private String season;

    private String synopsis;

}