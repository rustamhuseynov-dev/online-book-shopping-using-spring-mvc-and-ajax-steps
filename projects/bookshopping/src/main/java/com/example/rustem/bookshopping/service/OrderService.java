package com.example.rustem.bookshopping.service;

import java.util.List;

import com.example.rustem.bookshopping.dto.OrderDto;
import com.example.rustem.bookshopping.entity.Order;

public interface OrderService {

	List<OrderDto> findAll();

	OrderDto findAllById(Integer id);

	List<Order> addOrder(Order order);

	List<OrderDto> findAllByUsername(String username);
}
