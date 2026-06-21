package com.vedant.pensieve.dtos;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThoughtDTO {
	private Long thoughtId;
	private String thoughtTitle;
	private String message;
	private String tags;
	private LocalDateTime createdOn;
	private LocalDateTime modifiedOn;
	private Long userId;
}
