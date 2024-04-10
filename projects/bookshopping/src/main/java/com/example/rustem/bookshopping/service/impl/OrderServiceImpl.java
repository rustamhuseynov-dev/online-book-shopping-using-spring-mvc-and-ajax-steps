package com.example.rustem.bookshopping.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.rustem.bookshopping.config.MySession;
import com.example.rustem.bookshopping.dto.OrderDto;
import com.example.rustem.bookshopping.entity.BasketBook;
import com.example.rustem.bookshopping.entity.Customer;
import com.example.rustem.bookshopping.entity.Order;
import com.example.rustem.bookshopping.mapper.OrderMapper;
import com.example.rustem.bookshopping.repository.OrderRepository;
import com.example.rustem.bookshopping.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

	private final OrderRepository repository;

	private final MySession mySession;

	@Override
	public List<Order> addOrder(Order order) {
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
			double totalPrice = 0;

			for (int j = 0; j < order.getBasketBooks().size(); j++) {
				if (order.getBasketBooks().get(j).getBook().getUsername().equals(usernames.get(i))) {
					o.getBasketBooks().add(order.getBasketBooks().get(j));
					totalPrice += order.getBasketBooks().get(j).getBook().getPrice()
							* order.getBasketBooks().get(j).getCount();
				}
			}
			o.setTotalPrice(totalPrice);
			o.setUsername(usernames.get(i));
			orders.add(o);
		}

		return repository.saveAll(orders);

	}

	@Override
	public List<Order> save(Customer customer) {
		List<BasketBook> basketBooks = mySession.getBasketBooks();
		Order order = new Order();
		order.setCustomer(customer);
		order.setBasketBooks(basketBooks);
		order.setNote(customer.getNote());

		System.out.println(order);

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
			double totalPrice = 0;

			for (int j = 0; j < order.getBasketBooks().size(); j++) {
				if (order.getBasketBooks().get(j).getBook().getUsername().equals(usernames.get(i))) {
					o.getBasketBooks().add(order.getBasketBooks().get(j));
					totalPrice += order.getBasketBooks().get(j).getBook().getPrice()
							* order.getBasketBooks().get(j).getCount();
				}
			}
			o.setTotalPrice(totalPrice);
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
	public OrderDto findAllById(Integer id) {
		Order order = repository.findById(id).orElseThrow(() -> new RuntimeException("bele bir sifaris tapilmadi"));
		return OrderMapper.mapToOrderDto(order);
	}

	@Override
	public List<OrderDto> findAllByUsername(String username) {
		List<Order> orders = repository.findAllByUsername(username);
		return orders.stream().map((order) -> OrderMapper.mapToOrderDto(order)).collect(Collectors.toList());
	}

	@Override
	public Boolean saveBasketBooks(List<BasketBook> basketBooks) {
		mySession.setBasketBooks(basketBooks);
		return true;
	}
}
