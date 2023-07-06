package com.example.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin(origins = "*")
public class NoteController {

    private final NoteService service;

    @Autowired
    public NoteController(NoteService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<Note>> getAllNotes() {
        List<Note> allNotes = service.listAllNotes();
        return ResponseEntity.ok().body(allNotes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable("id") Long id) {
//        System.out.println(id);
        Note note = service.getNoteById(id);
        return ResponseEntity.ok().body(note);
    }

    @PostMapping
    ResponseEntity<Note> CreateNote(@RequestBody NoteDTO noteDTO) {
        Note newNote = service.createNote(noteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newNote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNoteById(@PathVariable("id") Long id) {
        service.deleteNoteById(id);
        return ResponseEntity.noContent().build();
    }
}
