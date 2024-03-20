package com.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.UserDTO;
import com.project.service.UserService;
import com.project.utility.ResponseStructure;

@RestController
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<Object>> addUser(@RequestBody UserDTO userDTO) {
		return userService.addUser(userDTO);
	}
}
