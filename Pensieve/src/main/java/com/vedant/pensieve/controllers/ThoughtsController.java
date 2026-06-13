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

import com.vedant.pensieve.dtos.ThoughtsDTO;
import com.vedant.pensieve.entities.Thoughts;
import com.vedant.pensieve.service.ThoughtsService;

@RestController
@RequestMapping("/v1/thoughts/")
public class ThoughtsController {
	ThoughtsService ThoughtsService;
	
	public ThoughtsController(ThoughtsService ThoughtsService) {
		this.ThoughtsService = ThoughtsService;
	}
	
	
	@GetMapping("")
	public List<ThoughtsDTO> fetchThoughts(){
		List<ThoughtsDTO> allThoughts = ThoughtsService.fetchAllThoughts();
		
		return allThoughts;
	}
	
	@PostMapping("")
	public ResponseEntity<Thoughts> saveThought(@RequestBody ThoughtsDTO Thoughtdto){
		Thoughts savedThought = ThoughtsService.addThought(Thoughtdto);
		
		return ResponseEntity.ok(savedThought);
	}
	
	@PutMapping("")
	public ResponseEntity<Thoughts> updateThought(@RequestBody ThoughtsDTO Thoughtdto){
		Thoughts updatedThought = ThoughtsService.updateThought(Thoughtdto);
		
		return ResponseEntity.ok(updatedThought);
	}
	
	@DeleteMapping("{ThoughtId}")
	public ResponseEntity<String> deleteThought(@PathVariable int ThoughtId){
		String deleteThought = ThoughtsService.deleteThought(ThoughtId);
		
		return ResponseEntity.ok(deleteThought);
	}

}
