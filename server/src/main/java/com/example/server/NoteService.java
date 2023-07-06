package com.example.server;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Note getNoteById(Long id) {
        Optional<Note> note = repo.getNoteById(id);
        if (note.isPresent()) {
            return note.get();
        }
        throw new IllegalArgumentException("Note not found");
    }

    public void deleteNoteById(Long id) {
        repo.delete(id);
    }

    public Note updateNoteById(Long id, NoteDTO noteDTO) {
        Note updateNote = new Note();
        updateNote.setTitle(noteDTO.title());
        updateNote.setNote(noteDTO.note());
        return repo.updateNoteById(id, updateNote);
    }
}
