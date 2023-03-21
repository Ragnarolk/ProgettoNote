package it.softwareInside.ProgettoNote.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.softwareInside.ProgettoNote.models.Note;
import it.softwareInside.ProgettoNote.service.NoteService;
import it.softwareInside.ProgettoNote.service.PdfService;

@RestController
public class NoteController {

	@Autowired
	NoteService noteService;
	
	@Autowired
	PdfService pdfService;
	
	@PostMapping("/generate-note")
	public boolean addNote(@RequestBody Note note) {
		return noteService.addNoteToDB(note);
	}
	
	@GetMapping("/show")
	public Iterable<Note> showNote() {
		return noteService.getAllNotes();
	}
	
	@PostMapping("/find")
	public Note findNote(@RequestParam("id") Integer id) {
		return noteService.getNoteById(id);
	}
	
	@DeleteMapping("/erase-note")
	public Note eraseNote(@RequestParam("id") Integer id) {
		return noteService.deleteNoteById(id);
	}
	
	@GetMapping("/genocide")
	public void genocide() {
		noteService.deleteAllNotes();
	}
	
	@PostMapping("/update")
	public boolean updateNote(@RequestBody Note note) {
		return noteService.updateNote(note);
	}
	
	@GetMapping("/create")
	public boolean newDocument(@RequestParam("id") Integer id) throws IOException {
		pdfService.creaDocumento(id);
		return true;
	}
	
}
