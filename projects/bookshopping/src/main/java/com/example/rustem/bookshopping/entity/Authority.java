package com.example.rustem.bookshopping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
