package com.example.rustem.bookshopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.rustem.bookshopping.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	List<Book> findAllByUsername(String username);

	@Query(value = "select * from book where name like %?1%", nativeQuery = true)
	List<Book> findAllSearch(String search);

	@Query(value = "select * from book where name like %?1% or description like %?1% or price like %?1% or page_count like %?1% or author like %?1%", nativeQuery = true)
	public List<Book> findAllSearchAllFields(String search);

	@Query(value = "select * from book where name like %?1% or description like %?1% or price like %?1% or page_count like %?1% or author like %?1% limit ?2,?3", nativeQuery = true)
	public List<Book> findAllSearchAllFieldsFindPartial(String search, Integer begin, Integer length);

}
