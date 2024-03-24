package com.example.rustem.bookshopping.service;

import java.util.List;

import org.springframework.ui.Model;

import com.example.rustem.bookshopping.dto.BookDto;

public interface BookService {

	List<BookDto> findAll();

	BookDto findAllById(Long id);

	BookDto addBook(BookDto bookDto);

	void deleteById(Long id);

	BookDto editBook(Long id, Model model);
}
