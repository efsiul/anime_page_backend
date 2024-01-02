package com.anime_pages.anime_page.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Data
@Entity
@Table(name = "anime_details")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnimeDetailsModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long malId;
    private String url;
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
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

    public void addGenre(GenreModels genre) {
        this.genres.add(genre);
        genre.setAnime(this);
    }

    public void addTheme(ThemeModels theme) {
        this.themes.add(theme);
        theme.setAnime(this);
    }

    public void addProducer(ProducerModels producer) {
        this.producers.add(producer);
        producer.setAnime(this);
    }

    public void addLicensor(LicensorModels licensor) {
        this.licensors.add(licensor);
        licensor.setAnime(this);
    }

    public void addStudio(StudioModels studio) {
        this.studios.add(studio);
        studio.setAnime(this);
    }

    public void addTitle(TitlesModels title) {
        this.titles.add(title);
        title.setAnime(this);
    }


}