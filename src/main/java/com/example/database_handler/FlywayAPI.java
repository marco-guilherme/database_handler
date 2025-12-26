package com.example.database_handler;

import org.flywaydb.core.Flyway;

public class FlywayAPI {
    public static void main(String[] arguments) {
        Flyway flyway = Flyway.configure()
                .dataSource(
                        System.getenv("DATABASE_URL"),
                        System.getenv("DATABASE_USERNAME"),
                        System.getenv("DATABASE_PASSWORD")
                )
                .schemas("library_database")
                .defaultSchema("library_database")
                .createSchemas(true)
                .load();

        flyway.migrate();
    }
}
