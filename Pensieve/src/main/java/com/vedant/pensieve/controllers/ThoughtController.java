package com.vedant.pensieve.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedant.pensieve.dtos.ThoughtDTO;
import com.vedant.pensieve.entities.Thought;
import com.vedant.pensieve.service.ThoughtService;

@RestController
@RequestMapping("/v1/thought/")
public class ThoughtController {
	ThoughtService thoughtService;
	
	public ThoughtController(ThoughtService thoughtservice) {
		this.thoughtService = thoughtservice;
	}
	
	@GetMapping("")
	public List<ThoughtDTO> fetchThought(){
		List<ThoughtDTO> allThoughts = thoughtService.fetchAllThought();
		
		return allThoughts;
	}
	
	@PostMapping("")
	public ResponseEntity<Thought> saveThought(@RequestBody ThoughtDTO thoughtdto){
		Thought savedThought = thoughtService.addThought(thoughtdto);
		
		return ResponseEntity.ok(savedThought);
	}
	
	@PutMapping("{thoughtId}")
	public ResponseEntity<Thought> updateThought(@RequestBody ThoughtDTO thoughtdto, @PathVariable long thoughtId){
		Thought updatedThought = thoughtService.updateThought(thoughtdto, thoughtId);
		
		return ResponseEntity.ok(updatedThought);
	}
	
	@DeleteMapping("{thoughtId}")
	public ResponseEntity<String> deleteThought(@PathVariable long thoughtId){
		String deleteThought = thoughtService.deleteThought(thoughtId);
		
		return ResponseEntity.ok(deleteThought);
	}

}
