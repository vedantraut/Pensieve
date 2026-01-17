package com.vedant.pensieve.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedant.pensieve.dtos.NotesDTO;
import com.vedant.pensieve.entities.Notes;
import com.vedant.pensieve.service.NotesService;

@RestController
public class NotesController {
	NotesService notesService;
	
	@Autowired
	public NotesController(NotesService notesService) {
		
	}
	
	
	@GetMapping("/notes")
	public List<NotesDTO> fetchNotes(){
		
		List<NotesDTO> allnotes = notesService.fetchAllNotes();
		
		return null;
	}

}
