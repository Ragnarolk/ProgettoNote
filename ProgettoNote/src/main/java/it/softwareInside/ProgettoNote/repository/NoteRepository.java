package it.softwareInside.ProgettoNote.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.softwareInside.ProgettoNote.models.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note, Integer> {

}
