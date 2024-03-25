package com.example.rustem.bookshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rustem.bookshopping.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
