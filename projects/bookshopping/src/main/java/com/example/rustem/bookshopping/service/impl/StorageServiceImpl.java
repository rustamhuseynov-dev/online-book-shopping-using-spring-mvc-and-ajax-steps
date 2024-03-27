package com.example.rustem.bookshopping.service.impl;

import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.rustem.bookshopping.service.StorageService;

@Service
public class StorageServiceImpl implements StorageService {

	@Override
	public void init() {
		// TODO Auto-generated method stub

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
