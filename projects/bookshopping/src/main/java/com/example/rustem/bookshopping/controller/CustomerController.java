package com.example.rustem.bookshopping.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(path = "/customers")
@RequiredArgsConstructor
public class CustomerController {

	@GetMapping
	public String showCustomerPage(Model model) {
		List<String> books = new ArrayList<>();
		for (int i = 1; i < 100; i++) {
			books.add("");
		}
		model.addAttribute("books", books);
		return "customer";
	}
}
