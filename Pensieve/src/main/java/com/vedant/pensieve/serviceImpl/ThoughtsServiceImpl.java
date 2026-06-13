package com.vedant.pensieve.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.vedant.pensieve.dao.ThoughtsRepo;
import com.vedant.pensieve.dtos.ThoughtsDTO;
import com.vedant.pensieve.entities.Thoughts;
import com.vedant.pensieve.exception.ThoughtNotFoundException;
import com.vedant.pensieve.service.ThoughtsService;

import jakarta.transaction.Transactional;

@Service
public class ThoughtsServiceImpl implements ThoughtsService {
	ThoughtsRepo ThoughtsRepo;
	
	public ThoughtsServiceImpl(ThoughtsRepo ThoughtsRepo) {
		this.ThoughtsRepo = ThoughtsRepo;
	}

	@Override
	@Transactional
	public List<ThoughtsDTO> fetchAllThoughts() {
		List<Thoughts> allThoughts = ThoughtsRepo.findAll();
		List<ThoughtsDTO> dtoList = new ArrayList<>();
		
		for(Thoughts Thought: allThoughts) {
			ThoughtsDTO Thoughtdto = new ThoughtsDTO();
						
			Thoughtdto.setThoughtId(Thought.getThoughtId());
			Thoughtdto.setThoughtTitle(Thought.getThoughtTitle());
			Thoughtdto.setCreatedBy(Thought.getCreatedBy());
			Thoughtdto.setCreatedOn(Thought.getCreatedOn());
			Thoughtdto.setMessage(Thought.getMessage());
			Thoughtdto.setModifiedBy(Thought.getModifiedBy());
			Thoughtdto.setModifiedOn(Thought.getModifiedOn());
			
			dtoList.add(Thoughtdto);
		}
		
		return dtoList;
	}

	@Override
	@Transactional
	public Thoughts addThought(ThoughtsDTO Thoughtdto) {
		
		Thoughts newThought = new Thoughts();
		
		newThought.setThoughtTitle(Thoughtdto.getThoughtTitle());
		newThought.setCreatedBy(Thoughtdto.getCreatedBy());
		newThought.setModifiedBy(Thoughtdto.getModifiedBy());
		newThought.setMessage(Thoughtdto.getMessage());
		newThought.setCreatedOn(LocalDateTime.now());
		newThought.setModifiedOn(LocalDateTime.now());
		
		ThoughtsRepo.save(newThought);
		
		return newThought;
	}

	@Override
	@Transactional
	public Thoughts updateThought(ThoughtsDTO Thoughtdto) {
		
		Thoughts existingThought = ThoughtsRepo.findById(Thoughtdto.getThoughtId()).orElseThrow(() -> new ThoughtNotFoundException("Thought is not found with id - "+Thoughtdto.getThoughtId()));
		
		existingThought.setThoughtTitle(Thoughtdto.getThoughtTitle());
		existingThought.setMessage(Thoughtdto.getMessage());
		existingThought.setCreatedBy(Thoughtdto.getCreatedBy());
		existingThought.setModifiedBy(Thoughtdto.getModifiedBy());
		existingThought.setModifiedOn(LocalDateTime.now());
		
		ThoughtsRepo.save(existingThought);
		
		return existingThought;
	}

	@Override
	@Transactional
	public String deleteThought(int ThoughtId) {
		Thoughts existingThought = ThoughtsRepo.findById(ThoughtId).orElseThrow(() -> new ThoughtNotFoundException("Thought not found with id - " + ThoughtId));
		ThoughtsRepo.delete(existingThought);
		
		return "Deleted Thought";
	}

}
