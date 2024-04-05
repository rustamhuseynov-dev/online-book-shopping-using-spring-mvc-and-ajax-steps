package com.example.rustem.bookshopping.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.rustem.bookshopping.dto.OrderDto;
import com.example.rustem.bookshopping.entity.BasketBook;
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
	public List<OrderDto> addOrder(OrderDto orderDto) {
		ArrayList<String> usernames = new ArrayList<>();
		for (int i = 0; i < orderDto.getBasketBooks().size(); i++) {
			BasketBook basketBook = orderDto.getBasketBooks().get(i);
			if (usernames.contains(basketBook.getBook().getUsername())) {
			} else {
				usernames.add(basketBook.getBook().getUsername());
			}
		}

		List<Order> orders = new ArrayList<>();

		for (int i = 0; i < usernames.size(); i++) {
			Order o = new Order();
			o.setNote(orderDto.getNote());
			o.setCustomer(orderDto.getCustomer());

			for (int j = 0; j < orderDto.getBasketBooks().size(); j++) {
				if (orderDto.getBasketBooks().get(j).getBook().getUsername().equals(usernames.get(i))) {
					o.getBasketBooks().add(orderDto.getBasketBooks().get(j));
				}
			}
			o.setUsername(usernames.get(i));
			orders.add(o);
		}

		List<Order> savedOrder = repository.saveAll(orders);
		return OrderMapper.mapToOrderDtoList(savedOrder);
	}

	@Override
	public List<Order> save(Order order) {
		ArrayList<String> usernames = new ArrayList<>();
		for (int i = 0; i < order.getBasketBooks().size(); i++) {
			BasketBook basketBook = order.getBasketBooks().get(i);
			if (usernames.contains(basketBook.getBook().getUsername())) {
			} else {
				usernames.add(basketBook.getBook().getUsername());
			}
		}

		List<Order> orders = new ArrayList<>();

		for (int i = 0; i < usernames.size(); i++) {
			Order o = new Order();
			o.setNote(order.getNote());
			o.setCustomer(order.getCustomer());

			for (int j = 0; j < order.getBasketBooks().size(); j++) {
				if (order.getBasketBooks().get(j).getBook().getUsername().equals(usernames.get(i))) {
					o.getBasketBooks().add(order.getBasketBooks().get(j));
				}
			}
			o.setUsername(usernames.get(i));
			orders.add(o);
		}

		return repository.saveAll(orders);
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
