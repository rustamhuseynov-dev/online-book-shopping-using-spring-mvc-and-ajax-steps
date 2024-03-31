package com.example.rustem.bookshopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rustem.bookshopping.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findAllByUsername(String username);

}
