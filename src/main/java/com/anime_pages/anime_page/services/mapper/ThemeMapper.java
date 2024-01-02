package com.anime_pages.anime_page.services.mapper;

import java.util.ArrayList;
import java.util.List;

import com.anime_pages.anime_page.models.ThemeModels;
import com.anime_pages.anime_page.models.dtos.ThemeDTO;

public class ThemeMapper {

    public static List<ThemeModels> mapToThemeModelsList(List<ThemeDTO> themeDTOList) {
        List<ThemeModels> themeModelsList = new ArrayList<>();

        if (themeDTOList != null) {
            for (ThemeDTO themeDTO : themeDTOList) {
                ThemeModels themeModels = mapToThemeModels(themeDTO);
                themeModelsList.add(themeModels);
            }
        }
        return themeModelsList;
    }

    private static ThemeModels mapToThemeModels(ThemeDTO themeDTO) {
        ThemeModels themeModels = new ThemeModels();
        themeModels.setMalId(themeDTO.getMalId());
        themeModels.setType(themeDTO.getType());
        themeModels.setName(themeDTO.getName());
        themeModels.setUrl(themeDTO.getUrl());
        // Puedes establecer otros campos si es necesario

        return themeModels;
    }
}
