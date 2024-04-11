package com.example.rustem.bookshopping.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "orders")
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String note;
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
