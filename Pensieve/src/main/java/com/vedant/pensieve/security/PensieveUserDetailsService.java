package com.vedant.pensieve.security;

import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vedant.pensieve.dao.UserRepo;
import com.vedant.pensieve.entities.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PensieveUserDetailsService implements UserDetailsService {

	private final UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.findByEmail(username)
		        .orElseThrow(() ->
		                new UsernameNotFoundException(
		                        "No user found with email: " + username));
		
//		Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken()); 
		
		return org.springframework.security.core.userdetails.User
				.builder()
				.username(user.getEmail())
				.password(user.getPassword())
				.authorities(List.of())
				.build();
	}

}
