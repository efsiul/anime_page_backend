package com.anime_pages.anime_page.models;

public class ImagesModels {
    private ImageTypeModels jpg;
    private ImageTypeModels webp;

    public ImagesModels() {
    }

    public ImagesModels(ImageTypeModels jpg, ImageTypeModels webp) {
        this.jpg = jpg;
        this.webp = webp;
    }

    public ImageTypeModels getJpg() {
        return jpg;
    }

    public void setJpg(ImageTypeModels jpg) {
        this.jpg = jpg;
    }

    public ImageTypeModels getWebp() {
        return webp;
    }

    public void setWebp(ImageTypeModels webp) {
        this.webp = webp;
    }   
}
