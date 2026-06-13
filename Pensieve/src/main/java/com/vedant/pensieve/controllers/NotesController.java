package com.vedant.pensieve.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedant.pensieve.dtos.NotesDTO;
import com.vedant.pensieve.entities.Notes;
import com.vedant.pensieve.service.NotesService;

@RestController
@RequestMapping("/v1/notes/")
public class NotesController {
	NotesService notesService;
	
	public NotesController(NotesService notesService) {
		this.notesService = notesService;
	}
	
	
	@GetMapping("")
	public List<NotesDTO> fetchNotes(){
		List<NotesDTO> allnotes = notesService.fetchAllNotes();
		
		return allnotes;
	}
	
	@PostMapping("")
	public ResponseEntity<Notes> saveNote(@RequestBody NotesDTO notedto){
		Notes savedNote = notesService.addNote(notedto);
		
		return ResponseEntity.ok(savedNote);
	}
	
	@PutMapping("")
	public ResponseEntity<Notes> updateNote(@RequestBody NotesDTO notedto){
		Notes updatedNote = notesService.updateNote(notedto);
		
		return ResponseEntity.ok(updatedNote);
	}
	
	@DeleteMapping("{noteId}")
	public ResponseEntity<String> deleteNote(@PathVariable int noteId){
		String deleteNote = notesService.deleteNote(noteId);
		
		return ResponseEntity.ok(deleteNote);
	}

}
