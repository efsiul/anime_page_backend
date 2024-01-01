package com.anime_pages.anime_page.models;

import com.anime_pages.anime_page.models.dtos.ImagesDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Trailer {
    @Column(name = "youtube_id") 
    private String youtubeId;

    @Column(name = "url")
    private String url;

    @Column(name = "embed_url")
    private String embedUrl;

    @Column(name = "images")    
    private ImagesDTO images;

    public Trailer() {
    }

    public Trailer(String youtubeId, String url, String embedUrl, ImagesDTO images) {
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
