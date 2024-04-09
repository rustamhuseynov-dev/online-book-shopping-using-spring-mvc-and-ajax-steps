package com.example.rustem.bookshopping.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rustem.bookshopping.dto.BookDto;
import com.example.rustem.bookshopping.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/rest/books")
@RequiredArgsConstructor
public class BookRestController {

	private final BookService service;

	// find All REST API
	@GetMapping
	public ResponseEntity<List<BookDto>> findAll(Model model) {
		List<BookDto> bookDto = service.findAll(model);
		return ResponseEntity.ok(bookDto);
	}

	// find All by id REST API
	@GetMapping(path = "/{id}")
	public ResponseEntity<BookDto> findAllById(@PathVariable Integer id) {
		BookDto bookDto = service.findAllById(id);
		return ResponseEntity.ok(bookDto);
	};

}
