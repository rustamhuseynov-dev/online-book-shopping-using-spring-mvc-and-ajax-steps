package com.example.rustem.bookshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(path = "/customers")
@RequiredArgsConstructor
public class CustomerController {

	@GetMapping
	public String showCustomerPage() {
		return "customer";
	}
}
