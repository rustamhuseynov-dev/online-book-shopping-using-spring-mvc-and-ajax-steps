package com.example.rustem.bookshopping.mapper;

import com.example.rustem.bookshopping.dto.UserDto;
import com.example.rustem.bookshopping.entity.User;

public class UserMapper {

	public static User mapToUser(UserDto userDto) {
		User user = new User(
				userDto.getUsername(),
				userDto.getPassword(),
				userDto.getEnabled()
				);
		return user;
	}

	public static UserDto mapToUserDto(User user) {
		UserDto userDto = new UserDto(
				user.getUsername(),
				user.getPassword(),
				user.getEnabled()
				);
		return userDto;
	}
	
}	
