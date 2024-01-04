package com.anime_pages.anime_page.services.mapper;

import com.anime_pages.anime_page.models.dtos.AnimeDTO;
import com.anime_pages.anime_page.models.dtos.AnimeDetailsDTO;

public class AnimeMapper {

    public static AnimeDetailsDTO mapToAnimeDetailsDTO(AnimeDTO anime) {
        AnimeDetailsDTO animeDetailsDTO = new AnimeDetailsDTO();

        animeDetailsDTO.setMal_id(anime.getMal_id());
        animeDetailsDTO.setUrl(anime.getUrl());
        animeDetailsDTO.setTitle(anime.getTitle());
        animeDetailsDTO.setType(anime.getType());
        animeDetailsDTO.setSource(anime.getSource());
        animeDetailsDTO.setEpisodes(anime.getEpisodes());
        animeDetailsDTO.setStatus(anime.getStatus());
        animeDetailsDTO.setDuration(anime.getDuration());
        animeDetailsDTO.setRating(anime.getRating());
        animeDetailsDTO.setRank(anime.getRank());
        animeDetailsDTO.setPopularity(anime.getPopularity());
        animeDetailsDTO.setScore(anime.getScore());
        animeDetailsDTO.setSynopsis(anime.getSynopsis());
        animeDetailsDTO.setSeason(anime.getSeason());   
        

        return animeDetailsDTO;
    }

}
