package com.example.database_handler;

import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.*;

public class JOOQProgramaticSourceCodeGenerator {
    public static void main(String[] arguments) {
        Configuration configuration = new Configuration();
        Generator generator = new Generator();
        Generate generate = new Generate();
        Database database = new Database();
        Target target = new Target();
        Jdbc JDBC = new Jdbc();

        JDBC.withDriver("org.postgresql.Driver");
        JDBC.withUrl(System.getenv("DATABASE_URL"));
        JDBC.withUser(System.getenv("DATABASE_USERNAME"));
        JDBC.withPassword(System.getenv("DATABASE_PASSWORD"));

        database.withName("org.jooq.meta.postgres.PostgresDatabase");
        database.withIncludes(".*");
        database.withExcludes("");
        database.withInputSchema("library_database");

        generate.withPojos(true);
        generate.withRecords(true);

        target.withPackageName("com.example.database_handler.jooq.generated");
        target.withDirectory("target/generated-sources/jooq");

        generator.withDatabase(database);
        generator.withGenerate(generate);
        generator.withTarget(target);

        configuration.withJdbc(JDBC);
        configuration.withGenerator(generator);

        try {
            GenerationTool.generate(configuration);
        }
        catch(Exception exception) {
            System.out.println("An error occurred while running the jOOQ source code generator. Details: " + exception.getMessage());

            throw new RuntimeException(exception);
        }
    }
}
