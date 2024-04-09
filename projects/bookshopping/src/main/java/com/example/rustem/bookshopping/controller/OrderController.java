package com.example.rustem.bookshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rustem.bookshopping.config.MySession;
import com.example.rustem.bookshopping.repository.OrderRepository;
import com.example.rustem.bookshopping.service.OrderService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(path = "/orders")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService service;

	private final OrderRepository repository;

	private final MySession mySession;

	@GetMapping
	public String showOrderPage(Model model) {
		model.addAttribute("orders", repository.findAllByUsername(mySession.getUsername()));
		return "orders";
	}

	@GetMapping(path = "/confirm-order")
	public String showConfirmOrderPage() {
		return "confirm-order";
	}
}
