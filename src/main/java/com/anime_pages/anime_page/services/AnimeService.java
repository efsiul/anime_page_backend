package com.anime_pages.anime_page.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.anime_pages.anime_page.interfaces.InterfaceAnimeService;
import com.anime_pages.anime_page.models.AnimeDetailsModels;
import com.anime_pages.anime_page.models.GenreModels;
import com.anime_pages.anime_page.models.LicensorModels;
import com.anime_pages.anime_page.models.ProducerModels;
import com.anime_pages.anime_page.models.StudioModels;
import com.anime_pages.anime_page.models.ThemeModels;
import com.anime_pages.anime_page.models.TitlesModels;
import com.anime_pages.anime_page.models.dtos.AnimeDetailsDTO;
import com.anime_pages.anime_page.repositories.IAnimeRepository;
import com.anime_pages.anime_page.repositories.IGenreRepository;
import com.anime_pages.anime_page.repositories.ILicensorRepository;
import com.anime_pages.anime_page.repositories.IProducerRepository;
import com.anime_pages.anime_page.repositories.IStudioRepository;
import com.anime_pages.anime_page.repositories.IThemeRepository;
import com.anime_pages.anime_page.repositories.ITitlesRepository;
import com.anime_pages.anime_page.services.mapper.GenreMapper;
import com.anime_pages.anime_page.services.mapper.ImagesMapper;
import com.anime_pages.anime_page.services.mapper.LicensorMapper;
import com.anime_pages.anime_page.services.mapper.ProducerMapper;
import com.anime_pages.anime_page.services.mapper.StudioMapper;
import com.anime_pages.anime_page.services.mapper.ThemeMapper;
import com.anime_pages.anime_page.services.mapper.TitlesMapper;

import java.util.List;

@Service
public class AnimeService implements InterfaceAnimeService {
    
    @Autowired
    private IAnimeRepository animeRepository;

    @Autowired
    private IProducerRepository producerRepository;

    @Autowired
    private ILicensorRepository licensorRepository;
    
    @Autowired
    private IStudioRepository studioRepository;

    @Autowired
    private IGenreRepository genreRepository;

    @Autowired
    private IThemeRepository themeRepository;

    @Autowired
    private ITitlesRepository titleRepository;

    @Value("${jikan.api.url}")
    private String jikanApiUrl; 

    private RestTemplate restTemplate;

    public AnimeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public AnimeDetailsDTO searchAnimeTitle(String title) {
        String apiUrl = jikanApiUrl + "/anime?q=" + title + "&sfw";
        try {
            String apiResponse = restTemplate.getForObject(apiUrl, String.class);
            System.out.println("API Response: " + apiResponse);
    
            AnimeDetailsDTO animeDetailsDTO = restTemplate.getForObject(apiUrl, AnimeDetailsDTO.class);
    
            // Guardar en la base de datos
            AnimeDetailsModels animeDetailsModels = mapDtoToEntity(animeDetailsDTO);
    
            // Guardar objetos asociados individualmente
            saveAssociatedObjects(animeDetailsModels);
    
            // Guardar objeto principal
            animeRepository.save(animeDetailsModels);
    
            return animeDetailsDTO;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AnimeDetailsDTO> listTopAnimeTitles() {
        // En este metodo necesito consultar la api y obtener los datos de los animes, luego guardar los datos en la base de datos

        return null;
    }

    @Override
    public AnimeDetailsDTO getAnimeDetailsFromApi(String malId) {
        // Lógica para consumir la API de Animes (Jikan) y obtener detalles
        String apiUrl = jikanApiUrl + "/anime/" + malId;
        return restTemplate.getForObject(apiUrl, AnimeDetailsDTO.class);
    }

    @Override
    public Double calculateAverageScore(List<AnimeDetailsDTO> animeDetailsList) {
        // Lógica para calcular la puntuación promedio de todas las temporadas del anime
        // Puedes implementar esto según tu necesidad
        double sum = 0;
        for (AnimeDetailsDTO animeDetails : animeDetailsList) {
            sum += animeDetails.getScore();
        }
        return sum / animeDetailsList.size();
    }

    @Override
    public String getRecommendationMessage(Double score) {
        // Lógica para aplicar la regla de negocio y obtener un mensaje según la puntuación
        if (score >= 1 && score <= 4) {
            return "No lo recomiendo.";
        } else if (score >= 5 && score <= 7) {
            return "Puedes divertirte.";
        } else {
            return "Genial, este es uno de los mejores animes.";
        }
    }

    private AnimeDetailsModels mapDtoToEntity(AnimeDetailsDTO dto) {
        AnimeDetailsModels entity = new AnimeDetailsModels();

        entity.setMalId(dto.getMalId());
        entity.setUrl(dto.getUrl());
        entity.setTitle(dto.getTitle());
        entity.setPopularity(dto.getPopularity());
        entity.setScore(dto.getScore());
        entity.setSynopsis(dto.getSynopsis());
        entity.setDuration(dto.getDuration());  
        entity.setEpisodes(dto.getEpisodes());  
        entity.setStatus(dto.getStatus());  
        entity.setSource(dto.getSource());  
        entity.setType(dto.getType());  
        entity.setRating(dto.getRating());  
        entity.setRank(dto.getRank());  

        List<GenreModels> genreModelsList = GenreMapper.mapToGenreModelsList(dto.getGenres());
        for (GenreModels genre : genreModelsList) {
            entity.addGenre(genre);
        }

        entity.setImages(ImagesMapper.mapToImagesModels(dto.getImages()));

        List<ProducerModels> producerModelsList = ProducerMapper.mapToProducerModelsList(dto.getProducers());
        for (ProducerModels producer : producerModelsList) {
            entity.addProducer(producer);
        }

        List<LicensorModels> licensorModelsList = LicensorMapper.mapToLicensorModelsList(dto.getLicensors());
        for (LicensorModels licensor : licensorModelsList) {
            entity.addLicensor(licensor);
        }

        List<StudioModels> studiosModelsList = StudioMapper.mapToStudioModelsList(dto.getStudios());
        for (StudioModels studio : studiosModelsList) {
            entity.addStudio(studio);
        }

        List<ThemeModels> ThemeModelsList = ThemeMapper.mapToThemeModelsList(dto.getThemes());
        for (ThemeModels theme : ThemeModelsList) {
            entity.addTheme(theme);
        }

        List<TitlesModels> TitlesModelsList = TitlesMapper.mapToTitlesModelsList(dto.getTitles());
        for (TitlesModels title : TitlesModelsList) {
            entity.addTitle(title);
        }

        return entity;
    }


    private void saveAssociatedObjects(AnimeDetailsModels animeDetailsModels) {
        // Verifica y guarda productores
        if (animeDetailsModels.getProducers() != null) {
            producerRepository.saveAll(animeDetailsModels.getProducers());
        }else{
            System.out.println("No hay productores");
        }
    
        if (animeDetailsModels.getLicensors() != null) {
            licensorRepository.saveAll(animeDetailsModels.getLicensors());
        }else{
            System.out.println("No hay licenciatarios");
        }
    
        if (animeDetailsModels.getStudios() != null) {
            studioRepository.saveAll(animeDetailsModels.getStudios());
        }else{
            System.out.println("No hay estudios");
        }
    
        if (animeDetailsModels.getGenres() != null) {
            genreRepository.saveAll(animeDetailsModels.getGenres());
        }else{
            System.out.println("No hay generos");
        }
    
        if (animeDetailsModels.getThemes() != null) {
            themeRepository.saveAll(animeDetailsModels.getThemes());
        }else{
            System.out.println("No hay temas");
        }
    
        if (animeDetailsModels.getTitles() != null) {
            titleRepository.saveAll(animeDetailsModels.getTitles());
        }else{
            System.out.println("No hay titulos");
        }
    }
}
