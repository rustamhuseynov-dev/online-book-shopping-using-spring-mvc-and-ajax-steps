package com.example.rustem.bookshopping.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String note;
	private String name;
	@CreationTimestamp
	private Timestamp register;
	private Double totalPrice;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private List<BasketBook> basketBooks;
	private String username;

	public Integer getId() {
		return id;
	}

	public String getNote() {
		return note;
	}

	public String getName() {
		return name;
	}

	public Timestamp getRegister() {
		return register;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<BasketBook> getBasketBooks() {
		if (basketBooks == null) {
			basketBooks = new ArrayList<BasketBook>();
		}
		return basketBooks;
	}

	public String getUsername() {
		return username;
	}

}
