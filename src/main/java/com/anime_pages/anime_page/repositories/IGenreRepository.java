package com.anime_pages.anime_page.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.anime_pages.anime_page.models.GenreModels;

@Repository
public interface IGenreRepository extends JpaRepository<GenreModels, Long> {
    

}