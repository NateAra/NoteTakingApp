package com.example.server;

import jakarta.persistence.*;

@Entity
@Table(name = "user_note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String note;

    public Note(String title, String note) {
        this.title = title;
        this.note = note;
    }

    public Note() {

    }

    public Long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
