package com.bookstore;

import com.bookstore.entity.Book;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.bookstore.service.BookstoreService;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            bookstoreService.persistAuthorsAndBooks();
            bookstoreService.fetchBookWithAuthor();
        };
    }
}

/*
 * How To Define An Association That Reference @NaturalId

Description: This is a SpringBoot application that defines a @ManyToOne relationship that doesn't reference a primary key column. It references a Hibernate @NaturalId column.

Key points:

rely on @JoinColumn(referencedColumnName = "natural_id_column")
 * 
 * 
 */
