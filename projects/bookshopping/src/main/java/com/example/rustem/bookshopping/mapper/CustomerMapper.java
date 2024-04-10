package com.example.rustem.bookshopping.mapper;

import com.example.rustem.bookshopping.dto.CustomerDto;
import com.example.rustem.bookshopping.entity.Customer;

public class CustomerMapper {

	public static Customer mapToCustomer(CustomerDto customerDto) {
		Customer customer = new Customer(
				customerDto.getId(),
				customerDto.getName(),
				customerDto.getAddress(),
				customerDto.getPhone(),
				customerDto.getEmail(),
				customerDto.getPhone()
				);
		return customer;
	}
	
	public static CustomerDto mapToCustomerDto(Customer customer) {
		CustomerDto customerDto = new CustomerDto(
				customer.getId(),
				customer.getName(),
				customer.getAddress(),
				customer.getPhone(),
				customer.getEmail(),
				customer.getPhone()
				);
		return customerDto;
	}
}
