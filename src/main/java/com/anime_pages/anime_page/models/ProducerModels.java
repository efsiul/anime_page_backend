package com.anime_pages.anime_page.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProducerModels {

    @Column(name = "mal_id")
    private Long malId;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    public ProducerModels() {
    }

    public ProducerModels(Long malId, String type, String name, String url) {
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
