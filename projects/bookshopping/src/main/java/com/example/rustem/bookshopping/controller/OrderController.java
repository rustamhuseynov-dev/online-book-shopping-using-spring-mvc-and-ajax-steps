package com.example.rustem.bookshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rustem.bookshopping.config.MySession;
import com.example.rustem.bookshopping.entity.Customer;
import com.example.rustem.bookshopping.repository.OrderRepository;
import com.example.rustem.bookshopping.service.OrderService;

import jakarta.validation.Valid;
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
	public String showConfirmOrderPage(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "confirm-order";
	}

	@GetMapping(path = "/order-confirmation-message")
	public String showOrderConfirmationPage() {
		return "order-confirmation-message";
	}

	@PostMapping(path = "/confirm-order-process")
	public String confirmOrderProcess(@Valid @ModelAttribute(name = "customer") Customer customer,
			BindingResult result) {
		if (result.hasErrors()) {
			return "confirm-order";
		}
		service.save(customer);
		return "redirect:/orders/order-confirmation-message";
	}
}
