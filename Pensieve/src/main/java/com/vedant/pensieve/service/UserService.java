package com.vedant.pensieve.service;

import java.util.List;

import com.vedant.pensieve.dtos.UserDTO;
import com.vedant.pensieve.entities.User;

public interface UserService {

	public List<UserDTO> fetchAllUsers();

	public User addUser(UserDTO userdto);
	
}
