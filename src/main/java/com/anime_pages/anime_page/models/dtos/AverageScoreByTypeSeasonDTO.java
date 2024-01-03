package com.anime_pages.anime_page.models.dtos;

import lombok.Data;

@Data
public class AverageScoreByTypeSeasonDTO {
    private String type;
    private double average;

    public AverageScoreByTypeSeasonDTO(String type, double average) {
        this.type = type;
        this.average = average;
    }
}
