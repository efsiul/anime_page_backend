package com.anime_pages.anime_page.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "anime_details")
public class AnimeDetailsModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long malId;
    private String url;

    
    private String title;


    @Embedded
    private ImagesModels images;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anime")
    private List<TitlesModels> titles;

    private String type;
    private String source;
    private Integer episodes;
    private String status;

    private String duration;
    private String rating;
    private int rank;
    private int popularity;
    private Double score;

    @Column(name = "synopsis", length = 4000)
    private String synopsis;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anime")
    private List<ProducerModels> producers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anime")
    private List<LicensorModels> licensors;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anime")
    private List<StudioModels> studios;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anime")
    private List<GenreModels> genres;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anime")
    private List<ThemeModels> themes;


    public AnimeDetailsModels() {
    }

    public AnimeDetailsModels(Long id, Long malId, String url, String title, ImagesModels images,
            List<TitlesModels> titles, String type, String source, Integer episodes, String status,
            String duration, String rating, int rank, int popularity, Double score, String synopsis,
            List<ProducerModels> producers, List<LicensorModels> licensors, List<StudioModels> studios,
            List<GenreModels> genres, List<ThemeModels> themes) {
        this.id = id;
        this.malId = malId;
        this.url = url;
        this.title = title;
        this.images = images;
        this.titles = titles;
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
        this.producers = producers;
        this.licensors = licensors;
        this.studios = studios;
        this.genres = genres;
        this.themes = themes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ImagesModels getImages() {
        return images;
    }

    public void setImages(ImagesModels images) {
        this.images = images;
    }

    public List<TitlesModels> getTitles() {
        return titles;
    }

    public void setTitles(List<TitlesModels> titles) {
        this.titles = titles;
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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
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

    public List<ProducerModels> getProducers() {
        return producers;
    }

    public void setProducers(List<ProducerModels> producers) {
        this.producers = producers;
    }

    public List<LicensorModels> getLicensors() {
        return licensors;
    }

    public void setLicensors(List<LicensorModels> licensors) {
        this.licensors = licensors;
    }

    public List<StudioModels> getStudios() {
        return studios;
    }

    public void setStudios(List<StudioModels> studios) {
        this.studios = studios;
    }

    public List<GenreModels> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreModels> genres) {
        this.genres = genres;
    }

    public List<ThemeModels> getThemes() {
        return themes;
    }

    public void setThemes(List<ThemeModels> themes) {
        this.themes = themes;
    }

}