package com.vedant.pensieve.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotesDTO {
	private int noteId;
	private String noteTitle;
	private String message;
	private LocalDateTime createdOn;
	private LocalDateTime modifiedOn;
	private int createdBy;
	private int modifiedBy;
}
