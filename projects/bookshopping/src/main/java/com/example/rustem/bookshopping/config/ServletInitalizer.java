package com.example.rustem.bookshopping.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.example.rustem.bookshopping.BookshoppingApplication;

public class ServletInitalizer extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BookshoppingApplication.class);
	}
}
