package com.vedant.pensieve.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThoughtsDTO {
	private int thoughtId;
	private String thoughtTitle;
	private String message;
	private LocalDateTime createdOn;
	private LocalDateTime modifiedOn;
	private int createdBy;
	private int modifiedBy;
}
