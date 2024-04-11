package com.example.rustem.bookshopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.rustem.bookshopping.dto.UserDto;
import com.example.rustem.bookshopping.entity.User;
import com.example.rustem.bookshopping.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

	private final UserService service;

	private boolean userCreated = false;

	@GetMapping(path = "/show-login")
	public String showLoginPage(Model model, HttpServletRequest request) {
		if (userCreated) {
			model.addAttribute("userCreated", "");
			userCreated = false;
		}
		request.getSession().invalidate();
		return "my-custom-login";
	}

	@GetMapping(path = "/create-account")
	public String showCreateAccount(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "create-account";
	}

	@PostMapping(path = "/create-account-process")
	public String saveUser(@Valid @ModelAttribute(name = "user") UserDto dto, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return "create-account";
		}
		service.addUser(dto);
		userCreated = true;
		return "redirect:/show-login";
	}
}
