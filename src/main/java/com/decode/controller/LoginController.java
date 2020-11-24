package com.decode.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.decode.model.User;

@RestController
public class LoginController {

	@GetMapping(value = "/userlogin")
	public ResponseEntity<User> login() {
		User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return new ResponseEntity<User>(principal, HttpStatus.OK);
	}
}
