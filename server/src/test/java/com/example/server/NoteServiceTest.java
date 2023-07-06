//package com.example.server;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//public class NoteServiceTest {
//
//    @Mock
//    private NoteRepository repo;
//
//    @InjectMocks
//    private NoteService service;
//
//    @Test
//    public void testCreateNote() {
//        NoteDTO noteDTO = new NoteDTO("Title", "Note String");
//
//        Note expectedNote = new Note();
//        expectedNote.setTitle(noteDTO.title());
//        expectedNote.setNote(noteDTO.note());
//
//        when(repo.createNote(Mockito.any(Note.class))).thenReturn(expectedNote);
//
//        Note createdNote = service.createNote(noteDTO);
//
//        verify(repo).createNote(expectedNote);
//
//        assertEquals(expectedNote.getTitle(), createdNote.getTitle());
//        assertEquals(expectedNote.getNote(), createdNote.getNote());
//
//    }
//
//}
