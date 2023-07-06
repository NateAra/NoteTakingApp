package com.example.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {


    private final NoteRepository repo;

    @Autowired
    public NoteService(NoteRepository repo) {
        this.repo = repo;
    }

    public List<Note> listAllNotes() {
        return repo.listNotes();
    }

    public Note createNote(NoteDTO noteDTO) {
        Note note = new Note();
        note.setTitle(noteDTO.title());
        note.setNote(noteDTO.note());
        return repo.createNote(note);
    }
}
