package com.anime_pages.anime_page.models;

public class ImageTypeModels {
    private String original;
    private String small;
    private String tiny;

    public ImageTypeModels() {
    }   

    public ImageTypeModels(String original, String small, String tiny) {
        this.original = original;
        this.small = small;
        this.tiny = tiny;
    }

    public String getOriginal() {
        return original;
    }
    public void setOriginal(String original) {
        this.original = original;
    }
    public String getSmall() {
        return small;
    }
    public void setSmall(String small) {
        this.small = small;
    }
    public String getTiny() {
        return tiny;
    }
    public void setTiny(String tiny) {
        this.tiny = tiny;
    }
}
