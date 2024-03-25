package com.example.rustem.bookshopping.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.rustem.bookshopping.config.MySession;
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

	private final MySession session;

	@Override
	public List<BookDto> findAll(Model model) {
		List<Book> books = repository.findAllByUsername(session.getUsername());
		model.addAttribute("username", "İstifadəçi: " + session.getUsername());
		return books.stream().map((book) -> BookMapper.mapToBookDto(book)).collect(Collectors.toList());
	}

	@Override
	public BookDto findAllById(Long id) {
		Book book = repository.findById(id).orElseThrow(() -> new RuntimeException("bele bir kitab yoxdur"));
		return BookMapper.mapToBookDto(book);
	}

	@Override
	public BookDto addBook(BookDto bookDto) {
		Book book = BookMapper.mapToBook(bookDto);
		book.setImage("fake.jpg");
		book.setUsername(session.getUsername());
		Book savedBook = repository.save(book);
		return BookMapper.mapToBookDto(savedBook);
	}

	@Override
	public void deleteById(Long id) {
		Book book = repository.findById(id).orElseThrow(() -> new RuntimeException("bele bir kitab tapilmadi"));
		repository.deleteById(id);

	}

	@Override
	public BookDto editBook(Long id, Model model) {
		Book book = repository.findById(id).orElseThrow(() -> new RuntimeException("bele bir kitab tapilmadi"));
		repository.findById(id).get();
		model.addAttribute("book", book);
		return BookMapper.mapToBookDto(book);
	}

}
