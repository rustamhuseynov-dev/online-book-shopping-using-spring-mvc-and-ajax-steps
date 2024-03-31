package com.example.rustem.bookshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rustem.bookshopping.service.OrderService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(path = "/orders")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService service;

	@GetMapping
	public String showOrderPage(Model model) {
		model.addAttribute("orders", service.findAll());
		return "orders";
	}

	@GetMapping(path = "/confirm-order")
	public String showConfirmOrderPage() {
		return "confirm-order";
	}
}
