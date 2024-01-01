package com.anime_pages.anime_page;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AnimePageApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimePageApplication.class, args);
	}

}
