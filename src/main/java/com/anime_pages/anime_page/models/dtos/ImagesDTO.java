package com.anime_pages.anime_page.models.dtos;

public class ImagesDTO {
    private ImageTypeDto jpg;
    private ImageTypeDto webp;

    public ImagesDTO() {
    }

    public ImagesDTO(ImageTypeDto jpg, ImageTypeDto webp) {
        this.jpg = jpg;
        this.webp = webp;
    }

    public ImageTypeDto getJpg() {
        return jpg;
    }

    public void setJpg(ImageTypeDto jpg) {
        this.jpg = jpg;
    }

    public ImageTypeDto getWebp() {
        return webp;
    }

    public void setWebp(ImageTypeDto webp) {
        this.webp = webp;
    }
    
}
