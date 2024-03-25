package com.example.rustem.bookshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rustem.bookshopping.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String> {

}
