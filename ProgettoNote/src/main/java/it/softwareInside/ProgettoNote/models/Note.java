package it.softwareInside.ProgettoNote.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Note {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id;
	
	@NotNull(message="Il testo non puo' essere NULL")
	@NotBlank(message="Il testo non puo' essere vuoto")
	private String text;
	
	@NotNull(message="L'autore non puo' essere NULL")
	@NotBlank(message="L'autore non puo' essere vuoto")
	private String author;
	
	public Note(String text, String author) {
		setAuthor(author);
		setText(text);
	}
	
}
