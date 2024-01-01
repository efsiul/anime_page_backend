package com.anime_pages.anime_page.models.dtos;

import java.util.List;

public class AnimeDetailsDTO {
    private Long malId;
    private String url;
    private ImagesDTO images;
    private TrailerDTO trailer;
    private List<TitleDTO> titles;
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
    private String synopsis;
    private List<GenreDTO> genres;
    private List<ThemeDTO> themes;


    public AnimeDetailsDTO() {
    }   

    public AnimeDetailsDTO(
                Long malId,
                String url,
                ImagesDTO images,
                TrailerDTO trailer,
                List<TitleDTO> titles,
                String title,
                String type,
                String source,
                Integer episodes,
                String status,
                String duration,
                String rating,
                Integer rank,
                Integer popularity,
                Double score,
                String synopsis,
                List<GenreDTO> genres,
                List<ThemeDTO> themes) {
        this.malId = malId;
        this.url = url;
        this.images = images;
        this.trailer = trailer;
        this.titles = titles;
        this.title = title;
        this.type = type;
        this.source = source;
        this.episodes = episodes;
        this.status = status;
        this.duration = duration;
        this.rating = rating;
        this.rank = rank;
        this.popularity = popularity;
        this.score = score;
        this.synopsis = synopsis;
        this.genres = genres;
        this.themes = themes;
    }

    public Long getMalId() {
        return malId;
    }

    public void setMalId(Long malId) {
        this.malId = malId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ImagesDTO getImages() {
        return images;
    }

    public void setImages(ImagesDTO images) {
        this.images = images;
    }

    public TrailerDTO getTrailer() {
        return trailer;
    }

    public void setTrailer(TrailerDTO trailer) {
        this.trailer = trailer;
    }

    public List<TitleDTO> getTitles() {
        return titles;
    }

    public void setTitles(List<TitleDTO> titles) {
        this.titles = titles;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public List<GenreDTO> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreDTO> genres) {
        this.genres = genres;
    }

    public List<ThemeDTO> getThemes() {
        return themes;
    }

    public void setThemes(List<ThemeDTO> themes) {
        this.themes = themes;
    }


    
}