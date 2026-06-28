package com.vedant.pensieve.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vedant.pensieve.entities.User;

public interface UserRepo extends JpaRepository<User, Long> {

	boolean existsByEmail(String email);
	
	Optional<User> findByEmail(String email);

}
