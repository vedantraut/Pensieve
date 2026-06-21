package com.vedant.pensieve.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vedant.pensieve.dtos.UserDTO;
import com.vedant.pensieve.entities.User;
import com.vedant.pensieve.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/auth/")
public class UserController {
	UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("user")
	public List<UserDTO> fetchUsers(){
		List<UserDTO> allUsers = userService.fetchAllUsers();
		
		return allUsers;
	}
	
	@PostMapping("register")
	public ResponseEntity<User> saveUsers(@Valid @RequestBody UserDTO userdto){
		User user = userService.addUser(userdto);
		
		return ResponseEntity.status(201).body(user);
	}
}
