package com.anime_pages.anime_page.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImagesModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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


}