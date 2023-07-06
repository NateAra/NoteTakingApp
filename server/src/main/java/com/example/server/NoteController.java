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

    ResponseEntity<Note> CreateNote(@RequestBody NoteDTO noteDTO) {
        Note newNote = service.createNote(noteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newNote);
    }
}
