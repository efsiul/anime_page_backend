package com.anime_pages.anime_page;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
public class AnimePageApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimePageApplication.class, args);
	}


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
