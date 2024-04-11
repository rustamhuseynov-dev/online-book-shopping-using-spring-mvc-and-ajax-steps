package com.example.rustem.bookshopping.mapper;

import java.util.ArrayList;
import java.util.List;

import com.example.rustem.bookshopping.dto.OrderDto;
import com.example.rustem.bookshopping.entity.Order;

public class OrderMapper {

	public static Order mapToOrder(OrderDto orderDto) {
		Order order = new Order(orderDto.getId(), orderDto.getNote(), orderDto.getRegister(), orderDto.getTotalPrice(),
				orderDto.getCustomer(), orderDto.getBasketBooks(), orderDto.getUsername());
		return order;
	}

	public static OrderDto mapToOrderDto(Order order) {
		OrderDto orderDto = new OrderDto(order.getId(), order.getNote(), order.getTotalPrice(), order.getRegister(),
				order.getCustomer(), order.getBasketBooks(), order.getUsername());
		return orderDto;
	}

	public static List<OrderDto> mapToOrderDtoList(List<Order> orders) {
		List<OrderDto> orderDto = new ArrayList<>();
		return orderDto;
	}

}
