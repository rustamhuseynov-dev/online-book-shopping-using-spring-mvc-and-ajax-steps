package com.example.rustem.bookshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(path = "/orders")
@RequiredArgsConstructor
public class OrderController {

	@GetMapping
	public String showOrderPage() {
		return "orders";
	}

	@GetMapping(path = "/confirm-order")
	public String showConfirmOrderPage() {
		return "confirm-order";
	}
}
