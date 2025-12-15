package com.example.database_handler.repository;

import com.example.database_handler.jooq.generated.tables.pojos.Author;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.database_handler.jooq.generated.tables.Author.AUTHOR;

@Repository
public class LibraryRepository {
    private final DSLContext context;

    public LibraryRepository(DSLContext context) {
        this.context = context;
    }

    public List<Author> findAllAuthors() {
        return this.context
                .selectFrom(AUTHOR)
                .fetchInto(Author.class);
    }
}
