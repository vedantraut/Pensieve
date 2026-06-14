package com.vedant.pensieve.service;

import java.util.List;

import com.vedant.pensieve.dtos.ThoughtDTO;
import com.vedant.pensieve.entities.Thought;

public interface ThoughtService {

	public List<ThoughtDTO> fetchAllThought();

	public Thought addThought(ThoughtDTO thoughtdto);

	public Thought updateThought(ThoughtDTO thoughtdto, long thoughtId);

	public String deleteThought(long thoughtId);

}
