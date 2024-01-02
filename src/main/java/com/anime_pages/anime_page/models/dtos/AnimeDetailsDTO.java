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

    @JsonProperty("images")
    private ImagesDTO images;

    @JsonProperty("titles")
    private List<TitlesDTO> titles;

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
    private int rank;

    @JsonProperty("popularity")
    private int popularity;

    @JsonProperty("score")
    private Double score;

    @JsonProperty("synopsis")
    private String synopsis;

    @JsonProperty("producers")
    private List<ProducerDTO> producers;

    @JsonProperty("licensors")
    private List<LicensorDTO> licensors;

    @JsonProperty("studios")
    private List<StudioDTO> studios;

    @JsonProperty("genres")
    private List<GenreDTO> genres;

    @JsonProperty("themes")
    private List<ThemeDTO> themes;

    // Override toString() for debugging if needed

    @Override
    public String toString() {
        return "AnimeDetailsDTO{" +
                "id=" + id +
                ", malId=" + malId +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                // ... repeat for other fields
                '}';
    }
}
