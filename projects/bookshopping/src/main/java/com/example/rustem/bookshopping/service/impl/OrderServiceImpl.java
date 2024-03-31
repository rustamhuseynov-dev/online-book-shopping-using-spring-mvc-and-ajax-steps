package com.example.rustem.bookshopping.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.rustem.bookshopping.dto.OrderDto;
import com.example.rustem.bookshopping.entity.Order;
import com.example.rustem.bookshopping.mapper.OrderMapper;
import com.example.rustem.bookshopping.repository.OrderRepository;
import com.example.rustem.bookshopping.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

	private final OrderRepository repository;

	@Override
	public OrderDto addOrder(OrderDto orderDto) {
		Order order = OrderMapper.mapToOrder(orderDto);
		Order savedOrder = repository.save(order);
		return OrderMapper.mapToOrderDto(savedOrder);
	}

	@Override
	public List<OrderDto> findAll() {
		List<Order> orders = repository.findAll();
		return orders.stream().map((order) -> OrderMapper.mapToOrderDto(order)).collect(Collectors.toList());
	}

	@Override
	public OrderDto findAllById(Long id) {
		Order order = repository.findById(id).orElseThrow(() -> new RuntimeException("bele bir sifaris tapilmadi"));
		return OrderMapper.mapToOrderDto(order);
	}

	@Override
	public List<OrderDto> findAllByUsername(String username) {
		List<Order> orders = repository.findAllByUsername(username);
		return orders.stream().map((order) -> OrderMapper.mapToOrderDto(order)).collect(Collectors.toList());
	}
}
