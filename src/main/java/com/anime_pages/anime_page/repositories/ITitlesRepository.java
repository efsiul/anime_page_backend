package com.anime_pages.anime_page.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.anime_pages.anime_page.models.TitlesModels;

@Repository
public interface ITitlesRepository extends JpaRepository<TitlesModels, Long> {
}