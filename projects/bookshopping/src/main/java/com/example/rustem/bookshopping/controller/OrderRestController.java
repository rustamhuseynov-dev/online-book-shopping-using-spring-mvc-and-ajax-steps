package com.example.rustem.bookshopping.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rustem.bookshopping.dto.OrderDto;
import com.example.rustem.bookshopping.entity.Order;
import com.example.rustem.bookshopping.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/rest/orders")
@CrossOrigin
@RequiredArgsConstructor
public class OrderRestController {

	private final OrderService service;

	@PostMapping
	public List<Order> add(@RequestBody Order order) {
		List<Order> orders = service.addOrder(order);
		return orders;
	}

//	@PostMapping
//	public ResponseEntity<List<OrderDto>> addOrder(@RequestBody Order order) {
//		List<OrderDto> orders = service.addOrder(order);
//		return ResponseEntity.ok(orders);
//	}

	@GetMapping
	public ResponseEntity<List<OrderDto>> findAllOrder() {
		List<OrderDto> orderDto = service.findAll();
		return ResponseEntity.ok(orderDto);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<OrderDto> findById(@PathVariable Integer id) {
		OrderDto orderDto = service.findAllById(id);
		return ResponseEntity.ok(orderDto);
	}

	@GetMapping(path = "/{username}")
	public ResponseEntity<List<OrderDto>> findByUsername(@PathVariable String username) {
		List<OrderDto> orderDto = service.findAllByUsername(username);
		return ResponseEntity.ok(orderDto);
	}
}
