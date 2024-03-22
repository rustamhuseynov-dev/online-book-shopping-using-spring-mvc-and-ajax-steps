package com.example.rustem.bookshopping.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rustem.bookshopping.dto.BookDto;
import com.example.rustem.bookshopping.service.BookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(path = "/books")
@RequiredArgsConstructor
public class BookController {

	private final BookService service;
	
	@GetMapping
	public String showBooks(Model model){
		 List<BookDto> books = service.findAll();
		 model.addAttribute("books", books);
		 return "books";
	}
	
}
