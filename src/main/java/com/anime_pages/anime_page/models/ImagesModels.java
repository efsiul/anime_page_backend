package com.anime_pages.anime_page.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ImagesModels {

    @Column(name = "jpg_image_url")
    private String jpgImageUrl;

    @Column(name = "jpg_small_image_url")
    private String jpgSmallImageUrl;

    @Column(name = "jpg_large_image_url")
    private String jpgLargeImageUrl;

    @Column(name = "webp_image_url")
    private String webpImageUrl;

    @Column(name = "webp_small_image_url")
    private String webpSmallImageUrl;

    @Column(name = "webp_large_image_url")
    private String webpLargeImageUrl;

    public ImagesModels() {
    }

    public ImagesModels(String jpgImageUrl, String jpgSmallImageUrl, String jpgLargeImageUrl,
                        String webpImageUrl, String webpSmallImageUrl, String webpLargeImageUrl) {
        this.jpgImageUrl = jpgImageUrl;
        this.jpgSmallImageUrl = jpgSmallImageUrl;
        this.jpgLargeImageUrl = jpgLargeImageUrl;
        this.webpImageUrl = webpImageUrl;
        this.webpSmallImageUrl = webpSmallImageUrl;
        this.webpLargeImageUrl = webpLargeImageUrl;
    }

    public String getJpgImageUrl() {
        return jpgImageUrl;
    }

    public void setJpgImageUrl(String jpgImageUrl) {
        this.jpgImageUrl = jpgImageUrl;
    }

    public String getJpgSmallImageUrl() {
        return jpgSmallImageUrl;
    }

    public void setJpgSmallImageUrl(String jpgSmallImageUrl) {
        this.jpgSmallImageUrl = jpgSmallImageUrl;
    }

    public String getJpgLargeImageUrl() {
        return jpgLargeImageUrl;
    }

    public void setJpgLargeImageUrl(String jpgLargeImageUrl) {
        this.jpgLargeImageUrl = jpgLargeImageUrl;
    }

    public String getWebpImageUrl() {
        return webpImageUrl;
    }

    public void setWebpImageUrl(String webpImageUrl) {
        this.webpImageUrl = webpImageUrl;
    }

    public String getWebpSmallImageUrl() {
        return webpSmallImageUrl;
    }

    public void setWebpSmallImageUrl(String webpSmallImageUrl) {
        this.webpSmallImageUrl = webpSmallImageUrl;
    }

    public String getWebpLargeImageUrl() {
        return webpLargeImageUrl;
    }

    public void setWebpLargeImageUrl(String webpLargeImageUrl) {
        this.webpLargeImageUrl = webpLargeImageUrl;
    }

}