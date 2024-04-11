package com.example.rustem.bookshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rustem.bookshopping.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findByPhone(String phone);

	public Customer findByEmail(String email);
}
