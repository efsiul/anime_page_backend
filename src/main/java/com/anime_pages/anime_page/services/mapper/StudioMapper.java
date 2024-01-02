package com.anime_pages.anime_page.services.mapper;

import java.util.ArrayList;
import java.util.List;

import com.anime_pages.anime_page.models.StudioModels;
import com.anime_pages.anime_page.models.dtos.StudioDTO;

public class StudioMapper {

    public static List<StudioModels> mapToStudioModelsList(List<StudioDTO> studioDTOList) {
        List<StudioModels> studioModelsList = new ArrayList<>();

        if (studioDTOList != null) {
            for (StudioDTO studioDTO : studioDTOList) {
                StudioModels studioModels = mapToStudioModels(studioDTO);
                studioModelsList.add(studioModels);
            }
        }
        return studioModelsList;
    }

    private static StudioModels mapToStudioModels(StudioDTO studioDTO) {
        StudioModels studioModels = new StudioModels();
        studioModels.setMalId(studioDTO.getMalId());
        studioModels.setType(studioDTO.getType());
        studioModels.setName(studioDTO.getName());
        studioModels.setUrl(studioDTO.getUrl());

        return studioModels;
    }
}