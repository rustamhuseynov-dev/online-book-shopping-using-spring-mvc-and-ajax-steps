package com.example.rustem.bookshopping.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.rustem.bookshopping.dto.BookDto;
import com.example.rustem.bookshopping.entity.Book;
import com.example.rustem.bookshopping.mapper.BookMapper;
import com.example.rustem.bookshopping.repository.BookRepository;
import com.example.rustem.bookshopping.service.BookService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

	private final BookRepository repository;
	
	@Override
	public List<BookDto> findAll() {
		List<Book> books = repository.findAll();
		return books.stream()
				.map((book) -> BookMapper.mapToBookDto(book))
				.collect(Collectors.toList());
	}
	
	@Override
	public BookDto findAllById(Long id) {
		Book book = repository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("bele bir kitab yoxdur"));
		return BookMapper.mapToBookDto(book);
	}
}
