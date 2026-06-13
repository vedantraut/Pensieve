package com.vedant.pensieve.service;

import java.util.List;

import com.vedant.pensieve.dtos.NotesDTO;
import com.vedant.pensieve.entities.Notes;

public interface NotesService {

	public List<NotesDTO> fetchAllNotes();

	public Notes addNote(NotesDTO notedto);

	public Notes updateNote(NotesDTO notedto);

	public String deleteNote(int noteId);

}
