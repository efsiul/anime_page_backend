package com.anime_pages.anime_page.services.mapper;

import java.util.ArrayList;
import java.util.List;

import com.anime_pages.anime_page.models.TitlesModels;
import com.anime_pages.anime_page.models.dtos.TitlesDTO;

public class TitlesMapper {

    public static List<TitlesModels> mapToTitlesModelsList(List<TitlesDTO> titlesDTOList) {
        List<TitlesModels> titlesModelsList = new ArrayList<>();

        if (titlesDTOList != null) {        
            for (TitlesDTO titlesDTO : titlesDTOList) {
                TitlesModels titlesModels = mapToTitlesModels(titlesDTO);
                titlesModelsList.add(titlesModels);
            }
        }
        return titlesModelsList;
    }

    private static TitlesModels mapToTitlesModels(TitlesDTO titlesDTO) {
        TitlesModels titlesModels = new TitlesModels();
        titlesModels.setType(titlesDTO.getType());
        titlesModels.setTitle(titlesDTO.getTitle());

        return titlesModels;
    }
}