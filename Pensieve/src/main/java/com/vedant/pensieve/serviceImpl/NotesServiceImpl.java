package com.vedant.pensieve.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.vedant.pensieve.dao.NotesRepo;
import com.vedant.pensieve.dtos.NotesDTO;
import com.vedant.pensieve.entities.Notes;
import com.vedant.pensieve.exception.NoteNotFoundException;
import com.vedant.pensieve.service.NotesService;

import jakarta.transaction.Transactional;

@Service
public class NotesServiceImpl implements NotesService {
	NotesRepo notesRepo;
	
	public NotesServiceImpl(NotesRepo notesRepo) {
		this.notesRepo = notesRepo;
	}

	@Override
	@Transactional
	public List<NotesDTO> fetchAllNotes() {
		List<Notes> allNotes = notesRepo.findAll();
		List<NotesDTO> dtoList = new ArrayList<>();
		
		for(Notes note: allNotes) {
			NotesDTO notedto = new NotesDTO();
						
			notedto.setNoteId(note.getNoteId());
			notedto.setNoteTitle(note.getNoteTitle());
			notedto.setCreatedBy(note.getCreatedBy());
			notedto.setCreatedOn(note.getCreatedOn());
			notedto.setMessage(note.getMessage());
			notedto.setModifiedBy(note.getModifiedBy());
			notedto.setModifiedOn(note.getModifiedOn());
			
			dtoList.add(notedto);
		}
		
		return dtoList;
	}

	@Override
	@Transactional
	public Notes addNote(NotesDTO notedto) {
		
		Notes newNote = new Notes();
		
		newNote.setNoteTitle(notedto.getNoteTitle());
		newNote.setCreatedBy(notedto.getCreatedBy());
		newNote.setModifiedBy(notedto.getModifiedBy());
		newNote.setMessage(notedto.getMessage());
		newNote.setCreatedOn(LocalDateTime.now());
		newNote.setModifiedOn(LocalDateTime.now());
		
		notesRepo.save(newNote);
		
		return newNote;
	}

	@Override
	@Transactional
	public Notes updateNote(NotesDTO notedto) {
		
		Notes existingNote = notesRepo.findById(notedto.getNoteId()).orElseThrow(() -> new NoteNotFoundException("Note is not found with id - "+notedto.getNoteId()));
		
		existingNote.setNoteTitle(notedto.getNoteTitle());
		existingNote.setMessage(notedto.getMessage());
		existingNote.setCreatedBy(notedto.getCreatedBy());
		existingNote.setModifiedBy(notedto.getModifiedBy());
		existingNote.setModifiedOn(LocalDateTime.now());
		
		notesRepo.save(existingNote);
		
		return existingNote;
	}

	@Override
	@Transactional
	public String deleteNote(int noteId) {
		Notes existingNote = notesRepo.findById(noteId).orElseThrow(() -> new NoteNotFoundException("Note not found with id - " + noteId));
		notesRepo.delete(existingNote);
		
		return "Deleted Note";
	}

}
