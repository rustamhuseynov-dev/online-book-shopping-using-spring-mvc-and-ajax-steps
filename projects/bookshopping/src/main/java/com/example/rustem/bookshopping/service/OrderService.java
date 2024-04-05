package com.example.rustem.bookshopping.service;

import java.util.List;

import com.example.rustem.bookshopping.dto.OrderDto;
import com.example.rustem.bookshopping.entity.Order;

public interface OrderService {

	List<OrderDto> findAll();

	OrderDto findAllById(Long id);

	List<OrderDto> addOrder(OrderDto orderDto);

	List<Order> save(Order order);

	List<OrderDto> findAllByUsername(String username);
}
