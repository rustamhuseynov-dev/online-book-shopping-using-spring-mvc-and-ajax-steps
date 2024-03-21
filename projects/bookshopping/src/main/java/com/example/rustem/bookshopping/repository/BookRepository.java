package com.example.rustem.bookshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rustem.bookshopping.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
