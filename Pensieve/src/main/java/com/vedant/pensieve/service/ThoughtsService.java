package com.vedant.pensieve.service;

import java.util.List;

import com.vedant.pensieve.dtos.ThoughtsDTO;
import com.vedant.pensieve.entities.Thoughts;

public interface ThoughtsService {

	public List<ThoughtsDTO> fetchAllThoughts();

	public Thoughts addThought(ThoughtsDTO Thoughtdto);

	public Thoughts updateThought(ThoughtsDTO Thoughtdto);

	public String deleteThought(int ThoughtId);

}
