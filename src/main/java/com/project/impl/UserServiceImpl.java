package com.project.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.dto.UserDTO;
import com.project.model.User;
import com.project.repository.UserRepository;
import com.project.service.UserService;
import com.project.utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository repository;
	private ResponseStructure<Object> structure;

	public UserServiceImpl(UserRepository repository, ResponseStructure<Object> structure) {
		this.repository = repository;
		this.structure = structure;
	}

	@Override
	public ResponseEntity<ResponseStructure<Object>> addUser(UserDTO userDTO) {
		structure.setStatuscode(HttpStatus.CREATED.value())
				 .setMessage("User Created Successfully!")
				 .setData(repository.save(mapToUser(userDTO, new User())));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(structure);
	}

	private User mapToUser(UserDTO userDTO, User user) {
		user.setUserName(userDTO.getUserName());
		user.setEmail(userDTO.getEmail());
		user.setContactNo(userDTO.getContactNo());
		user.setPassword(userDTO.getPassword());
		return user;
	}
	
	
}
