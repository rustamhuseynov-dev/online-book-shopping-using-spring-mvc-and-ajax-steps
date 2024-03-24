package com.example.rustem.bookshopping.service.impl;

import org.springframework.stereotype.Service;

import com.example.rustem.bookshopping.dto.UserDto;
import com.example.rustem.bookshopping.entity.User;
import com.example.rustem.bookshopping.mapper.UserMapper;
import com.example.rustem.bookshopping.repository.UserRepository;
import com.example.rustem.bookshopping.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository repository;

	@Override
	public UserDto addUser(UserDto userDto) {
		User user = UserMapper.mapToUser(userDto);
		user.setEnabled(1);
		User savedUser = repository.save(user);
		return UserMapper.mapToUserDto(savedUser);
	}
}
