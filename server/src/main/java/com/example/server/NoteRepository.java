package com.example.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NoteRepository {
    private final JpaNoteRepository jpaRepo;

    @Autowired
    public NoteRepository(JpaNoteRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    public List<Note> listNotes() {
        Iterable<Note> notes = jpaRepo.findAll();
        return Streamable.of(notes).toList();
    }

    public Note createNote(Note note) {
        return jpaRepo.save(note);
    }

    public Optional<Note> getNoteById(Long id) {
        return jpaRepo.findById(id);
    }

    public void delete(Long id) {
        jpaRepo.deleteById(id);
    }


}
