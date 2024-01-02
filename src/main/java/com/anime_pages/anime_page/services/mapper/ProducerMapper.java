package com.anime_pages.anime_page.services.mapper;

import java.util.ArrayList;
import java.util.List;

import com.anime_pages.anime_page.models.ProducerModels;
import com.anime_pages.anime_page.models.dtos.ProducerDTO;

public class ProducerMapper {

    public static List<ProducerModels> mapToProducerModelsList(List<ProducerDTO> producerDTOList) {
        List<ProducerModels> producerModelsList = new ArrayList<>();
        
        if (producerDTOList != null) {
            for (ProducerDTO producerDTO : producerDTOList) {
                ProducerModels producerModels = mapToProducerModels(producerDTO);
                producerModelsList.add(producerModels);
            }
        }

        return producerModelsList;
    }

    private static ProducerModels mapToProducerModels(ProducerDTO producerDTO) {
        ProducerModels producerModels = new ProducerModels();
        producerModels.setMalId(producerDTO.getMalId());
        producerModels.setType(producerDTO.getType());
        producerModels.setName(producerDTO.getName());
        producerModels.setUrl(producerDTO.getUrl());

        return  producerModels; 
    }
}
