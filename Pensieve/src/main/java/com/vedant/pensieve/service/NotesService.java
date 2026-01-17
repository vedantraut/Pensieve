package com.vedant.pensieve.service;

import java.util.List;

import com.vedant.pensieve.dtos.NotesDTO;

public interface NotesService {

	public List<NotesDTO> fetchAllNotes();

}
