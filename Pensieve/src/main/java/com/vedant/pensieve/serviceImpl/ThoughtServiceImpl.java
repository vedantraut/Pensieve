package com.vedant.pensieve.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vedant.pensieve.dao.ThoughtRepo;
import com.vedant.pensieve.dao.UserRepo;
import com.vedant.pensieve.dtos.ThoughtDTO;
import com.vedant.pensieve.entities.Thought;
import com.vedant.pensieve.exception.ThoughtNotFoundException;
import com.vedant.pensieve.service.ThoughtService;
import jakarta.transaction.Transactional;

@Service
public class ThoughtServiceImpl implements ThoughtService {
	ThoughtRepo ThoughtRepo;
	UserRepo userRepo;
	
	@Autowired
	public ThoughtServiceImpl(ThoughtRepo ThoughtRepo, UserRepo userRepo) {
		this.ThoughtRepo = ThoughtRepo;
		this.userRepo = userRepo;
	}

	@Override
	@Transactional
	public List<ThoughtDTO> fetchAllThought() {
		List<Thought> allThought = ThoughtRepo.findAll();
		List<ThoughtDTO> dtoList = new ArrayList<>();
		
		for(Thought thought: allThought) {
			ThoughtDTO thoughtdto = new ThoughtDTO();
						
			thoughtdto.setThoughtId(thought.getThoughtId());
			thoughtdto.setThoughtTitle(thought.getThoughtTitle());
			thoughtdto.setMessage(thought.getMessage());
			thoughtdto.setTags(thought.getTags());
			thoughtdto.setUserId(thought.getUser().getUserId());
			thoughtdto.setCreatedOn(thought.getCreatedOn());
			thoughtdto.setModifiedOn(thought.getModifiedOn());
			
			dtoList.add(thoughtdto);
		}
		
		return dtoList;
	}

	@Override
	@Transactional
	public Thought addThought(ThoughtDTO thoughtdto) {
		
		Thought newThought = new Thought();
		
		newThought.setThoughtTitle(thoughtdto.getThoughtTitle());
		newThought.setMessage(thoughtdto.getMessage());
		newThought.setUser(userRepo.findById(thoughtdto.getUserId()).orElseThrow(() -> 
				new ThoughtNotFoundException("Thought is not found with id - "+thoughtdto.getThoughtId())));
		newThought.setTags(thoughtdto.getTags());
		newThought.setCreatedOn(LocalDateTime.now());
		newThought.setModifiedOn(LocalDateTime.now());
		
		ThoughtRepo.save(newThought);
		
		return newThought;
	}

	@Override
	@Transactional
	public Thought updateThought(ThoughtDTO thoughtdto, long thoughtId) {
		
		Thought existingThought = ThoughtRepo.findById(thoughtId).orElseThrow(() -> new ThoughtNotFoundException("Thought is not found with id - "+thoughtdto.getThoughtId()));
		
		existingThought.setThoughtTitle(thoughtdto.getThoughtTitle());
		existingThought.setMessage(thoughtdto.getMessage());
		existingThought.setUser(userRepo.findById(thoughtdto.getUserId()).orElseThrow(() -> 
				new ThoughtNotFoundException("Thought is not found with id - "+thoughtdto.getThoughtId())));
		existingThought.setTags(thoughtdto.getTags());
		existingThought.setModifiedOn(LocalDateTime.now());

		ThoughtRepo.save(existingThought);
		
		return existingThought;
	}

	@Override
	@Transactional
	public String deleteThought(long thoughtId) {
		Thought existingThought = ThoughtRepo.findById(thoughtId).orElseThrow(() -> new ThoughtNotFoundException("Thought not found with id - " + thoughtId));
		ThoughtRepo.delete(existingThought);
		
		return "Deleted Thought";
	}

}
