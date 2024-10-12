package com.aditya.DesignPattern.lld.libraryManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookService {

    private Map<String, Book> bookMap;

    public BookService() {
        bookMap = new HashMap<>();
    }

    public void addBook(Book book) {
        bookMap.put(book.getId(), book);
    }

    public Book getBookById(String id) {
        return bookMap.get(id);
    }

    public List<Book> getBooksByAuthor(String author) {
        List<Book> books = new ArrayList<>();

        for (Book book : bookMap.values()) {
            if (book.getAuthor().equals(author) && BookStatus.AVAILABLE.equals(book.getBookStatus())) {
                books.add(book);
            }
        }

        return books;
    }

    public List<Book> getAvailableBooks() {
        List<Book> books = new ArrayList<>();

        for (Book book : bookMap.values()) {
            if (BookStatus.AVAILABLE.equals(book.getBookStatus())) {
                books.add(book);
            }
        }

        return books;
    }

    public void removeBookById(String id) {
        bookMap.remove(id);
    }

    public void updateBookStatus(String id, BookStatus status) {
        Book book = bookMap.get(id);
        book.setBookStatus(status);
    }
}
