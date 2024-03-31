package com.example.rustem.bookshopping.mapper;

import com.example.rustem.bookshopping.dto.OrderDto;
import com.example.rustem.bookshopping.entity.Order;

public class OrderMapper {

	public static Order mapToOrder(OrderDto orderDto) {
		Order order = new Order(
				orderDto.getId(),
				orderDto.getName(),
				orderDto.getRegister(),
				orderDto.getTotalPrice(),
				orderDto.getCustomer(),
				orderDto.getBasketBooks(),
				orderDto.getUsername()
				);
		return order;
	}
	
	public static OrderDto mapToOrderDto(Order order) {
		OrderDto orderDto = new OrderDto(
				order.getId(),
				order.getName(),
				order.getTotalPrice(),
				order.getRegister(),
				order.getCustomer(),
				order.getBasketBooks(),
				order.getUsername()
				);
		return orderDto;
	}
}
