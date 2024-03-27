package com.example.rustem.bookshopping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.example.rustem.bookshopping.properties.StorageProperties;
import com.example.rustem.bookshopping.service.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class BookshoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookshoppingApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.init();
		};
	}
}
