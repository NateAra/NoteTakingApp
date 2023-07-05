package com.example.server;

import org.springframework.data.repository.CrudRepository;

public interface JpaNoteRepository extends CrudRepository<Note, Long> {
}
