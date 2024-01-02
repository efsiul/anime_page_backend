package com.anime_pages.anime_page.services.mapper;

import java.util.ArrayList;
import java.util.List;

import com.anime_pages.anime_page.models.GenreModels;
import com.anime_pages.anime_page.models.dtos.GenreDTO;

public class GenreMapper {

    public static List<GenreModels> mapToGenreModelsList(List<GenreDTO> genreDTOList) {
        List<GenreModels> genreModelsList = new ArrayList<>();

        if (genreDTOList != null) {           
            for (GenreDTO genreDTO : genreDTOList) {
                GenreModels genreModels = mapToGenreModels(genreDTO);
                genreModelsList.add(genreModels);
            }
        }
        
        return genreModelsList;
    }

    private static GenreModels mapToGenreModels(GenreDTO genreDTO) {
        GenreModels genreModels = new GenreModels();
        genreModels.setMalId(genreDTO.getMalId());
        genreModels.setType(genreDTO.getType());
        genreModels.setName(genreDTO.getName());
        genreModels.setUrl(genreDTO.getUrl());
        // Puedes establecer otros campos si es necesario

        return genreModels;
    }
}