package com.example.rustem.bookshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.rustem.bookshopping.config.MySession;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

	private final MySession mySession;

	@GetMapping(path = { "/home", "/" })
	public String showHomePage() {
		System.out.println(mySession.getBasketBooks());
		return "home";
	}
}
