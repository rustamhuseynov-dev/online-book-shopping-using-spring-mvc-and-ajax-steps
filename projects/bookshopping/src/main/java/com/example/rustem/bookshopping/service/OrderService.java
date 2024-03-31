package com.example.rustem.bookshopping.service;

import java.util.List;

import com.example.rustem.bookshopping.dto.OrderDto;

public interface OrderService {

	List<OrderDto> findAll();

	OrderDto findAllById(Long id);

	OrderDto addOrder(OrderDto orderDto);

	List<OrderDto> findAllByUsername(String username);
}
