package it.softwareInside.ProgettoNote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import it.softwareInside.ProgettoNote.models.Note;
import it.softwareInside.ProgettoNote.repository.NoteRepository;

@Service
public class NoteService {

	@Autowired
	NoteRepository noteRepository;
	
	public boolean addNoteToDB(@Validated Note note) {
		try {
			noteRepository.save(note);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public Iterable<Note> getAllNotes() {
		try {
			return noteRepository.findAll();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public Note getNoteById(Integer id) {
		try {
			return noteRepository.findById(id).get();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public Note deleteNoteById(Integer id) {
		try {
			Note note = noteRepository.findById(id).get();
			noteRepository.deleteById(id);
			return note;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void deleteAllNotes() {
		try {
			noteRepository.deleteAll();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public boolean updateNote(@Validated Note note) {
		try {
			noteRepository.findById(note.getId()).get();
			noteRepository.save(note);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
}
