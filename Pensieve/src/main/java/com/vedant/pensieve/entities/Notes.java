package com.vedant.pensieve.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Notes {
	private int noteId;
	private String noteTitle;
	private String message;
	private LocalDateTime createdOn;
	private LocalDateTime modifiedOn;
	private int createdBy;
	private int modifiedBy;

}
