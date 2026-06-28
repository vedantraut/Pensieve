package com.vedant.pensieve.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.vedant.pensieve.dao.UserRepo;
import com.vedant.pensieve.dtos.UserDTO;
import com.vedant.pensieve.entities.User;
import com.vedant.pensieve.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	UserRepo userRepo;
	PasswordEncoder passwordEncoder;

	@Override
	public List<UserDTO> fetchAllUsers() {
		List<User> allUsers = userRepo.findAll();
		List<UserDTO> userdtoList = new ArrayList<>();
		
		for(User user: allUsers) {
			UserDTO userdto = new UserDTO();
			
			userdto.setName(user.getName());
			userdto.setEmail(user.getEmail());
			
			userdtoList.add(userdto);
		}
		
		return userdtoList;
	}

	@Override
	public User addUser(UserDTO userdto) {
		User user = new User();
		
		if(userRepo.existsByEmail(userdto.getEmail())){
			throw new IllegalArgumentException("Email is already registered");
		}
		
		user.setName(userdto.getName());		
		user.setEmail(userdto.getEmail());
		user.setPassword(passwordEncoder.encode(userdto.getPassword()));
//		user.setPassword(userdto.getPassword());
		
		return userRepo.save(user);
	}

}
