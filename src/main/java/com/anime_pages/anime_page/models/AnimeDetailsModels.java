package com.anime_pages.anime_page.models;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "anime_details")
public class AnimeDetailsModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mal_id")
    private Long malId;


    @Column(name = "url")
    private String url;

    @Embedded
    @Column(name = "images")
    private ImagesModels images;
    
    @Embedded
    @Column(name = "trailer_url")
    private Trailer trailer;

    @ElementCollection
    @Embedded
    @Column(name = "titles")
    private List<TitleModels> titles;

    @Column(name = "type")
    private String type;

    @Column(name = "source")
    private String source;

    @Column(name = "episodes")
    private Integer episodes;

    @Column(name = "status")
    private String status;

    @Embedded
    @Column(name = "aired")
    private AiredModels aired;

    @Column(name = "duration")
    private String duration;

    @Column(name = "rating")
    private String rating;


    @Column(name = "rank")
    private int rank;

    @Column(name = "popularity")
    private int popularity;

    @Column(name = "score")
    private Double score;

    @Column(name = "synopsis", length = 4000)
    private String synopsis;

    @ElementCollection
    @Embedded
    @Column(name = "producers")
    private List<ProducerModels> producers;

    @ElementCollection
    @Embedded
    @Column(name = "licensors")
    private List<LicensorModels> licensors;

    @ElementCollection
    @Embedded
    @Column(name = "studios")
    private List<StudioModels> studios;

    @ElementCollection
    @Embedded
    @Column(name = "genres")
    private List<GenreModels> genres;

    @ElementCollection
    @Embedded
    @Column(name = "themes")
    private List<ThemeModels> themes;

    @ElementCollection
    @Embedded
    @Column(name = "demographics")
    private List<DemographicModels> demographics;

    public AnimeDetailsModels() {
    }   

    public AnimeDetailsModels(
                Long malId,
                String url, 
                ImagesModels images,
                Trailer trailer,
                List<TitleModels> titles,
                String type,
                String source,
                Integer episodes,
                String status,
                AiredModels aired,
                String duration,
                String rating,
                Integer rank,
                Integer popularity,
                Double score,
                String synopsis,
                List<ProducerModels> producers,
                List<LicensorModels> licensors,
                List<StudioModels> studios,
                List<GenreModels> genres,
                List<ThemeModels> themes,
                List<DemographicModels> demographics) {
        this.malId = malId;
        this.url = url;
        this.images = images;
        this.trailer = trailer;
        this.titles = titles;
        this.type = type;
        this.source = source;
        this.episodes = episodes;
        this.status = status;
        this.aired = aired;
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
        this.demographics = demographics;
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

    public ImagesModels getImages() {
        return images;
    }

    public void setImages(ImagesModels images) {
        this.images = images;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    public List<TitleModels> getTitles() {
        return titles;
    }

    public void setTitles(List<TitleModels> titles) {
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

    public AiredModels getAired() {
        return aired;
    }

    public void setAired(AiredModels aired) {
        this.aired = aired;
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

    public List<DemographicModels> getDemographics() {
        return demographics;
    }

    public void setDemographics(List<DemographicModels> demographics) {
        this.demographics = demographics;
    }   
    
    
}