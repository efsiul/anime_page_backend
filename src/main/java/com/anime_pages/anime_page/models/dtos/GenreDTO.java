package com.anime_pages.anime_page.models.dtos;

public class GenreDTO {
    private Long malId;
    private String type;
    private String name;
    private String url;
    
    public GenreDTO() {
    }

    public GenreDTO(Long malId, String type, String name, String url) {
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
