package com.example.rustem.bookshopping.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {

	@Size(min = 2, message = "Minumum 2 simvol olmalıdı!")
	@Size(max = 30, message = "Maximum 30 simvol olmalıdı")
	@NotEmpty(message = "boş qoymaq olmaz!")
	private String username;
	@Size(min = 2, message = "Minumum 2 simvol olmalıdı!")
	@Size(max = 30, message = "Maximum 30 simvol olmalıdı")
	@NotEmpty(message = "boş qoymaq olmaz!")
	private String password;
	private Integer enabled;
}
