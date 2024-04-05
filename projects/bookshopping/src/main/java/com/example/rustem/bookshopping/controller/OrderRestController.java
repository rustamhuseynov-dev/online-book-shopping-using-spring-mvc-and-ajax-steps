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
import com.example.rustem.bookshopping.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/rest/orders")
@CrossOrigin
@RequiredArgsConstructor
public class OrderRestController {

	private final OrderService service;

//	@PostMapping
//	public ResponseEntity<List<OrderDto>> add(@RequestBody OrderDto order) {
//		List<Order> orders = service.save(order);
//		return ResponseEntity.ok(orders);
//	}

	@PostMapping
	public ResponseEntity<List<OrderDto>> addOrder(@RequestBody OrderDto orderDto) {
		List<OrderDto> order = service.addOrder(orderDto);
		return ResponseEntity.ok(order);
	}

	@GetMapping
	public ResponseEntity<List<OrderDto>> findAllOrder() {
		List<OrderDto> orderDto = service.findAll();
		return ResponseEntity.ok(orderDto);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<OrderDto> findById(@PathVariable Long id) {
		OrderDto orderDto = service.findAllById(id);
		return ResponseEntity.ok(orderDto);
	}

	@GetMapping(path = "/{username}")
	public ResponseEntity<List<OrderDto>> findByUsername(@PathVariable String username) {
		List<OrderDto> orderDto = service.findAllByUsername(username);
		return ResponseEntity.ok(orderDto);
	}
}
