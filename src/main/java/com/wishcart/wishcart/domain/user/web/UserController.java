package com.wishcart.wishcart.domain.user.web;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/user")
@Slf4j
@Api("User Controller")
public class UserController {

	@Autowired
	private SessionRegistry sessionRegistry;

	@GetMapping("/loggedusers")
	public List<String> getAllActiveUsers() {
		List<String> users = new ArrayList<>();
		final List<Object> principals = sessionRegistry.getAllPrincipals();
		for (final Object principal : principals) {
			if (principal instanceof User) {
				users.add(((User) principal).getUsername());
			}
		}
		return users;
	}
}
