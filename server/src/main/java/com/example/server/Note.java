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
}
