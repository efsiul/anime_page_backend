package com.anime_pages.anime_page.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.anime_pages.anime_page.models.ThemeModels;

@Repository
public interface IThemeRepository extends JpaRepository<ThemeModels, Long> {
}