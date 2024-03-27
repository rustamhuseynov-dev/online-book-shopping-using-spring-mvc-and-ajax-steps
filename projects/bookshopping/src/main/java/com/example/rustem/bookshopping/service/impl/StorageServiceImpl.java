package com.example.rustem.bookshopping.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.rustem.bookshopping.exception.StorageException;
import com.example.rustem.bookshopping.exception.StorageFileNotFoundException;
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
		String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		String randomFileName = "";
		try {
			try (InputStream inputStream = multipartFile.getInputStream()) {
				String originalFileName = multipartFile.getOriginalFilename();
				UUID uuid = UUID.randomUUID();
				randomFileName = originalFileName
						.replace(originalFileName.substring(0, originalFileName.lastIndexOf(".")), uuid.toString());
				Files.copy(inputStream, this.rootLocation.resolve(randomFileName), StandardCopyOption.REPLACE_EXISTING);
			}
		} catch (IOException e) {
			throw new StorageException("Fayl yadda saxlana bilmədi: " + filename, e);
		}
		return randomFileName;
	}

	@Override
	public Path load(String filename) {
		return rootLocation.resolve(filename);
	}

	@Override
	public Resource loadAsResource(String filename) {
		try {
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new StorageFileNotFoundException("Fayl oxuna bilmedi: " + filename);
			}
		} catch (MalformedURLException e) {
			throw new StorageFileNotFoundException("Fayl oxuna bilmedi: " + filename, e);
		}
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
