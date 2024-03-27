package com.example.rustem.bookshopping.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties("storage")
@Getter
@Setter
public class StorageProperties {

	private String location = "upload-dir-book-shopping-spring-ajax-rustem-h";
}
