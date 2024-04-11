package com.example.rustem.bookshopping.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

	private Integer id;
	@NotEmpty(message = "Boş qoymaq olmaz!")
	@Size(min = 2, message = "Kitabın adını doğru daxil edin min 2")
	@Size(max = 50, message = "Kitabın adını doğru daxil edin max 20")
	private String name;
	@Size(max = 300, message = "max 300 qeyd etmek olar.")
	private String description;
	@NotNull(message = "boş qoymaq olmaz ")
	@Min(value = 1_0, message = "Kitabın qiymətini doğru daxil edin:min 10")
	@Max(value = 10_000, message = "Kitabın qiymətini doğru daxil edin:min 10000")
	private Double price;
	@Size(min = 2, message = "Yazıcının adını doğru daxil edin:min 2")
	@Size(max = 20, message = "Yazıcının adını doğru daxil edin:max 20")
	private String author;
	@Min(value = 10, message = "Kitabın Səhifəni doğru daxil edin:min 10")
	@Max(value = 10000, message = "Kitabın Səhifəni doğru daxil edin:min 10000")
	private Integer pageCount;
	private String image;
	private String username;
}
