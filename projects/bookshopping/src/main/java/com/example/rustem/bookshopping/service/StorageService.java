package com.example.rustem.bookshopping.service;

import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

	void init();

	String store(MultipartFile multipartFile);

	Path load(String filename);

	Resource loadAsResource(String filename);

	void deleteAll();
}
