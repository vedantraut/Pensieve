package com.vedant.pensieve.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThoughtDTO {
	private Long thoughtId;
	
	@NotBlank(message = "Thought title is required")
	@Size(max = 150, message = "Thought title cannot exceed 150 characters")
	private String thoughtTitle;
	
	@NotBlank(message = "Thought message is required")
	@Size(max = 10000, message = "Thought message cannot exceed 10,000 characters")
	private String message;
	
	@Size(max = 500, message = "Tags cannot exceed 500 characters")
	private String tags;
	
	@NotNull(message = "User id is required")
	private Long userId;
	
	private LocalDateTime createdOn;
	private LocalDateTime modifiedOn;
}
