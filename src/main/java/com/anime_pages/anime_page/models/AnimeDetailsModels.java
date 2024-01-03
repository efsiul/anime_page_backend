package com.anime_pages.anime_page.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Data
@Entity
@Table(name = "anime_details")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnimeDetailsModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mal_id")
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

    @Column(name = "synopsis", length = 8000)
    private String synopsis;
    
    private String season;

}