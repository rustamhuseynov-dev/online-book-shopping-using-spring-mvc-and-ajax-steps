package com.example.rustem.bookshopping.service;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.example.rustem.bookshopping.dto.BookDto;

public interface BookService {

	List<BookDto> findAll(Model model);

	BookDto findAllById(Long id);

	BookDto addBook(BookDto bookDto, MultipartFile image);

	void deleteById(Long id);

	BookDto editBook(Long id, Model model);
}
