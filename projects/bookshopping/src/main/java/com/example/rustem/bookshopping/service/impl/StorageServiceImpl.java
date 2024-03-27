package com.example.rustem.bookshopping.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.rustem.bookshopping.exception.StorageException;
import com.example.rustem.bookshopping.properties.StorageProperties;
import com.example.rustem.bookshopping.service.StorageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StorageServiceImpl implements StorageService {

	private final Path rootLocation;

	public StorageServiceImpl(StorageProperties propeties) {
		this.rootLocation = Paths.get(propeties.getLocation());
	}

	@Override
	public void init() {
		try {
			Files.createDirectories(rootLocation);
		} catch (IOException e) {
			throw new StorageException("Qovluğ yarana bilmədi", e);
		}

	}

	@Override
	public String store(MultipartFile multipartFile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Path load(String filename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource loadAsResource(String filename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
