package com.example.rustem.bookshopping.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rustem.bookshopping.dto.BookDto;
import com.example.rustem.bookshopping.service.BookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(path = "/customers")
@RequiredArgsConstructor
public class CustomerController {

	private final BookService bookService;

	@GetMapping
	public String showCustomerPage(Model model) {
		List<BookDto> books = bookService.findAll();
		model.addAttribute("books", books);
		return "customer";
	}
}
