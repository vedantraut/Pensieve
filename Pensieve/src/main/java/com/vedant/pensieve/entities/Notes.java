package com.vedant.pensieve.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Notes {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int noteId;
	private String noteTitle;
	private String message;
	@CreationTimestamp
	private LocalDateTime createdOn;
	@UpdateTimestamp
	private LocalDateTime modifiedOn;
	private int createdBy;
	private int modifiedBy;

}
