package com.example.rustem.bookshopping.service;

import java.util.List;

import com.example.rustem.bookshopping.dto.BookDto;

public interface BookService {
	
	List<BookDto> findAll();
	
	BookDto findAllById(Long id);
}
