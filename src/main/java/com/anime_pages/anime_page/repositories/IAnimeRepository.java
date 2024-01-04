package com.anime_pages.anime_page.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.anime_pages.anime_page.models.AnimeDetailsModels;

@Repository
public interface IAnimeRepository extends JpaRepository<AnimeDetailsModels, Long> {
    
    @Query("SELECT a FROM AnimeDetailsModels a WHERE a.mal_id = :malId")
    AnimeDetailsModels findByMalId(Integer malId);
    
    @Query("SELECT a FROM AnimeDetailsModels a WHERE a.mal_id = :malId and a.title = :title")
    AnimeDetailsModels findByTitleOrMalid(String title, Integer malId);

    boolean existsByTitle(String title);
    List<AnimeDetailsModels> findByType(String type);
    List<AnimeDetailsModels> findByTitle(String title);

}