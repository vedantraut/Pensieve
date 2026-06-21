package com.vedant.pensieve.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.vedant.pensieve.dao.ThoughtRepo;
import com.vedant.pensieve.dao.UserRepo;
import com.vedant.pensieve.dtos.ThoughtDTO;
import com.vedant.pensieve.entities.Thought;
import com.vedant.pensieve.exception.ThoughtNotFoundException;
import com.vedant.pensieve.exception.UserNotFoundException;
import com.vedant.pensieve.service.ThoughtService;
import jakarta.transaction.Transactional;

@Service
public class ThoughtServiceImpl implements ThoughtService {
	ThoughtRepo thoughtRepo;
	UserRepo userRepo;
	
	public ThoughtServiceImpl(ThoughtRepo thoughtRepo, UserRepo userRepo) {
		this.thoughtRepo = thoughtRepo;
		this.userRepo = userRepo;
	}

	@Override
	@Transactional
	public List<ThoughtDTO> fetchAllThought() {
		List<Thought> allThought = thoughtRepo.findAll();
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
				new UserNotFoundException("User is not found with id - "+thoughtdto.getUserId())));
		newThought.setTags(thoughtdto.getTags());
		
		thoughtRepo.save(newThought);
		
		return newThought;
	}

	@Override
	@Transactional
	public Thought updateThought(ThoughtDTO thoughtdto, long thoughtId) {
		
		Thought existingThought = thoughtRepo.findById(thoughtId).orElseThrow(() -> 
			new ThoughtNotFoundException("Thought is not found with id - "+thoughtId));
		
		existingThought.setThoughtTitle(thoughtdto.getThoughtTitle());
		existingThought.setMessage(thoughtdto.getMessage());
		existingThought.setTags(thoughtdto.getTags());

		thoughtRepo.save(existingThought);
		
		return existingThought;
	}

	@Override
	@Transactional
	public String deleteThought(long thoughtId) {
		Thought existingThought = thoughtRepo.findById(thoughtId).orElseThrow(() -> 
			new ThoughtNotFoundException("Thought not found with id - " + thoughtId));
		thoughtRepo.delete(existingThought);
		
		return "Deleted Thought";
	}

}
