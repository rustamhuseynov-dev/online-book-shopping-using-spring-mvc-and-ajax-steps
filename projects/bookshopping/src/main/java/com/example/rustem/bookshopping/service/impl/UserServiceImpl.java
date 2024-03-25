package com.example.rustem.bookshopping.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.rustem.bookshopping.dto.UserDto;
import com.example.rustem.bookshopping.entity.Authority;
import com.example.rustem.bookshopping.entity.User;
import com.example.rustem.bookshopping.mapper.AuthorityMapper;
import com.example.rustem.bookshopping.mapper.UserMapper;
import com.example.rustem.bookshopping.repository.UserRepository;
import com.example.rustem.bookshopping.service.AuthorityService;
import com.example.rustem.bookshopping.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository repository;
	private final AuthorityService authorityService;

	@Override
	public UserDto addUser(UserDto userDto) {
		User user = UserMapper.mapToUser(userDto);
		user.setPassword("{noop}" + userDto.getPassword());
		user.setEnabled(1);
		Authority authority = AuthorityMapper.mapToAuthority(userDto);
		authority.setAuthority("ROLE_ADMIN");
		authorityService.addAuthority(authority);
		Optional<User> userExists = repository.findById(user.getUsername());
		if (userExists.isPresent()) {
			throw new RuntimeException("bu username istifade olunub");
		}
		User savedUser = repository.save(user);
		return UserMapper.mapToUserDto(savedUser);
	}
}
