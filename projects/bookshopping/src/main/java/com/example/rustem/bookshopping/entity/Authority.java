package com.example.rustem.bookshopping.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "authorities")
@Getter
@Setter
@NoArgsConstructor
public class Authority {
	@Id
	private String username;
	private String authority;

	public Authority(String username) {
		this.username = username;
	}

}
