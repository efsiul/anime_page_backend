package com.anime_pages.anime_page.models.dtos;

public class TrailerDTO {
    private String youtubeId;
    private String url;
    private String embedUrl;
    private ImagesDTO images;

    public TrailerDTO() {
    }

    public TrailerDTO(String youtubeId, String url, String embedUrl, ImagesDTO images) {
        this.youtubeId = youtubeId;
        this.url = url;
        this.embedUrl = embedUrl;
        this.images = images;
    }
    
    
    public String getYoutubeId() {
        return youtubeId;
    }
    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getEmbedUrl() {
        return embedUrl;
    }
    public void setEmbedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
    }
    public ImagesDTO getImages() {
        return images;
    }
    public void setImages(ImagesDTO images) {
        this.images = images;
    }

}
