package com.vedant.pensieve.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	private String name;
	
	@Column(nullable=false, unique=true)
	private String email;
	private String password;
	
	@OneToMany(mappedBy="user")
	@JsonBackReference
	private List<Thought> thoughts;
}
