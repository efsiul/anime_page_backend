package com.anime_pages.anime_page.services.mapper;

import java.util.Objects;

import com.anime_pages.anime_page.models.ImagesModels;
import com.anime_pages.anime_page.models.dtos.ImagesDTO;

public class ImagesMapper {

    public static ImagesModels mapToImagesModels(ImagesDTO imagesDTO) {
        if (imagesDTO == null) {
            return null;
        }
        ImagesModels imagesModels = new ImagesModels();
        imagesModels.setJpgImageUrl(imagesDTO.getJpgImageUrl());
        imagesModels.setJpgSmallImageUrl(imagesDTO.getJpgSmallImageUrl());
        imagesModels.setJpgLargeImageUrl(imagesDTO.getJpgLargeImageUrl());
        imagesModels.setWebpImageUrl(imagesDTO.getWebpImageUrl());
        imagesModels.setWebpSmallImageUrl(imagesDTO.getWebpSmallImageUrl());
        imagesModels.setWebpLargeImageUrl(imagesDTO.getWebpLargeImageUrl());


        return imagesModels;
    }

    public static ImagesModels mapToImagesModels(ImagesDTO imagesDTO, ImagesModels existingImages) {
        if (imagesDTO == null) {
            return null;
        }
        ImagesModels imagesModels = Objects.requireNonNullElse(existingImages, new ImagesModels());
        imagesModels.setJpgImageUrl(imagesDTO.getJpgImageUrl());
        imagesModels.setJpgSmallImageUrl(imagesDTO.getJpgSmallImageUrl());
        imagesModels.setJpgLargeImageUrl(imagesDTO.getJpgLargeImageUrl());
        imagesModels.setWebpImageUrl(imagesDTO.getWebpImageUrl());
        imagesModels.setWebpSmallImageUrl(imagesDTO.getWebpSmallImageUrl());
        imagesModels.setWebpLargeImageUrl(imagesDTO.getWebpLargeImageUrl());


        return imagesModels;
    }
}