package com.anime_pages.anime_page.models.dtos;

import lombok.Data;

@Data
public class AverageScoreByTypeSeasonDTO {
    private String title;
    private String type;
    private double average;

    public AverageScoreByTypeSeasonDTO(String title, String type, double average) {
        this.title = title;
        this.type = type;
        this.average = average;
    }
}
