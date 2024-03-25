package com.example.rustem.bookshopping.mapper;

import com.example.rustem.bookshopping.dto.UserDto;
import com.example.rustem.bookshopping.entity.Authority;

public class AuthorityMapper {

	public static Authority mapToAuthority(UserDto userDto) {
		Authority authority = new Authority(userDto.getUsername());
		return authority;
	}
}
