package com.anime_pages.anime_page.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class GenreModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mal_id")
    private Long malId;

    private String type;
    private String name;
    private String url;

    @ManyToOne
    @JoinColumn(name = "anime_id")
    private AnimeDetailsModels anime;
    

    public GenreModels() {
    }

    public GenreModels(Long malId, String type, String name, String url) {
        this.malId = malId;
        this.type = type;
        this.name = name;
        this.url = url;
    }


    public Long getMalId() {
        return malId;
    }

    public void setMalId(Long malId) {
        this.malId = malId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    

}
