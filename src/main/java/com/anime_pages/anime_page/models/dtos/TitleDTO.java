package com.anime_pages.anime_page.models.dtos;

public class TitleDTO {
    private String type;
    private String title;
    
    public TitleDTO() {
    }

    public TitleDTO(String type, String title) {
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