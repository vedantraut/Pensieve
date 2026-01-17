package com.vedant.pensieve.serviceImpl;

import java.util.List;

import com.vedant.pensieve.dao.NotesRepo;
import com.vedant.pensieve.dtos.NotesDTO;
import com.vedant.pensieve.entities.Notes;
import com.vedant.pensieve.service.NotesService;

public class NotesServiceImpl implements NotesService {
	NotesRepo notesRepo;
	
	public NotesServiceImpl(NotesRepo notesRepo) {
		
	}

	@Override
	public List<NotesDTO> fetchAllNotes() {
		List<Notes> allNotes = notesRepo.findAll();
		
		NotesDTO notedto = new NotesDTO();
		
//		notedto.setNoteId(0);
		
		return null;
	}

}
