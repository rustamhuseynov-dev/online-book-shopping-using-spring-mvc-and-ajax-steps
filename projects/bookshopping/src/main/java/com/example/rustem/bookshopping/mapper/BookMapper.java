package com.example.rustem.bookshopping.mapper;

import com.example.rustem.bookshopping.dto.BookDto;
import com.example.rustem.bookshopping.entity.Book;

public class BookMapper {

	public static Book mapToBook(BookDto bookDto) {
		Book book = new Book(
				bookDto.getId(),
				bookDto.getName(),
				bookDto.getDescription(),
				bookDto.getPrice()
				);
		return book;
	}
	public static BookDto mapToBookDto(Book book) {
		BookDto bookDto = new BookDto(
				book.getId(),
				book.getName(),
				book.getDescription(),
				book.getPrice()
				);
		return bookDto;
	}
}
