package com.example.server;

import jakarta.persistence.*;

@Entity
@Table(name = "user_note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    public Note(String name) {
        this.name = name;
    }

    public Note() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
