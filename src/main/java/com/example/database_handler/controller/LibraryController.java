package com.example.database_handler.controller;

import com.example.database_handler.jooq.generated.tables.pojos.Author;
import com.example.database_handler.service.LibraryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// http://127.0.0.1:8080/library/findAll

@RestController
@RequestMapping("/library")
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/findAll")
    public List<Author> findAllAuthors() {
        return this.libraryService.findAllAuthors();
    }
}
