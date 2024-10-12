package com.aditya.DesignPattern.lld.libraryManagementSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Book {

    private String id;
    private String title;
    private String author;
    private String publicationYear;
    private String isbn;
    private BookStatus bookStatus;

    public Book(String title, String author, String publicationYear, String isbn, BookStatus bookStatus) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.bookStatus = bookStatus;
    }
}
