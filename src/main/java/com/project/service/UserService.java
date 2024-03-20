package com.project.service;

import org.springframework.http.ResponseEntity;

import com.project.dto.UserDTO;
import com.project.utility.ResponseStructure;

public interface UserService {

	ResponseEntity<ResponseStructure<Object>> addUser(UserDTO userDTO);

}
