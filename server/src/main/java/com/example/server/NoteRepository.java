package com.example.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
