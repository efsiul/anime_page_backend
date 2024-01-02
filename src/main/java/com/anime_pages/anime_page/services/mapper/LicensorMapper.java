package com.anime_pages.anime_page.services.mapper;

import java.util.ArrayList;
import java.util.List;
import com.anime_pages.anime_page.models.LicensorModels;
import com.anime_pages.anime_page.models.dtos.LicensorDTO;

public class LicensorMapper {

    public static List<LicensorModels> mapToLicensorModelsList(List<LicensorDTO> licensorDTOList) {
        List<LicensorModels> licensorModelsList = new ArrayList<>();

        if (licensorDTOList != null) {
            for (LicensorDTO licensorDTO : licensorDTOList) {
                LicensorModels licensorModels = mapToLicensorModels(licensorDTO);
                licensorModelsList.add(licensorModels);
            }
        }
        return licensorModelsList;
    }

    private static LicensorModels mapToLicensorModels(LicensorDTO licensorDTO) {
        LicensorModels licensorModels = new LicensorModels();
        licensorModels.setMalId(licensorDTO.getMalId());
        licensorModels.setType(licensorDTO.getType());
        licensorModels.setName(licensorDTO.getName());
        licensorModels.setUrl(licensorDTO.getUrl());

        return licensorModels;
    }
}