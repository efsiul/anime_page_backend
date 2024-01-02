package com.anime_pages.anime_page.models.dtos;

import lombok.Data;

@Data
public class ImagesDTO {

    private Long id;

    private String jpgImageUrl;
    private String jpgSmallImageUrl;
    private String jpgLargeImageUrl;

    private String webpImageUrl;
    private String webpSmallImageUrl;
    private String webpLargeImageUrl;
    
}
