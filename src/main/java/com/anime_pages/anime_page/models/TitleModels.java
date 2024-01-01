package com.anime_pages.anime_page.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class TitleModels {

    @Column(name = "type")
    private String type;

    @Column(name = "title")
    private String title;

    public TitleModels() {
    }

    public TitleModels(String type, String title) {
        this.type = type;
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    
}