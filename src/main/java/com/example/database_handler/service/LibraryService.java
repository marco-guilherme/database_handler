package com.example.database_handler.service;

import com.example.database_handler.jooq.generated.tables.pojos.Author;
import com.example.database_handler.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<Author> findAllAuthors() {
        return this.libraryRepository.findAllAuthors();
    }
}
