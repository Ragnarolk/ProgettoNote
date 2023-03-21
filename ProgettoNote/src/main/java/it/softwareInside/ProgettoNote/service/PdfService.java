package it.softwareInside.ProgettoNote.service;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.softwareInside.ProgettoNote.models.Note;
import it.softwareInside.ProgettoNote.repository.NoteRepository;

@Service
public class PdfService {
	
	@Autowired
	NoteRepository noteRepository;
	
	public void creaDocumento(Integer id) throws IOException {
		Note notaScelta = noteRepository.findById(id).get();
		String text= "Autore: " + notaScelta.getAuthor() + " Contenuto: " + notaScelta.getText();
		
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage(page);
		
		PDPageContentStream contentStream = new PDPageContentStream(document, page);

		contentStream.setFont(PDType1Font.TIMES_BOLD, 12);
		contentStream.beginText();
		contentStream.newLineAtOffset(25, 700);
		contentStream.showText(text);
		contentStream.endText();
		contentStream.close();

		document.save("C:\\Users\\ragnarolk\\Desktop\\testNote.pdf");
		document.close();
	}
	
}
