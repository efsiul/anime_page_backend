package com.anime_pages.anime_page;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestAnimePageApplication {

	public static void main(String[] args) {
		SpringApplication.from(AnimePageApplication::main).with(TestAnimePageApplication.class).run(args);
	}

}
