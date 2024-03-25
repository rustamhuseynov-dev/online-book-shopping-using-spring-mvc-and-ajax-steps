package com.example.rustem.bookshopping.service.impl;

import org.springframework.stereotype.Service;

import com.example.rustem.bookshopping.entity.Authority;
import com.example.rustem.bookshopping.repository.AuthorityRepository;
import com.example.rustem.bookshopping.service.AuthorityService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {

	private final AuthorityRepository repository;

	@Override
	public void addAuthority(Authority authority) {
		repository.save(authority);

	}
}
