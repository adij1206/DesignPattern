package com.aditya.DesignPattern.pattern.v2;

import java.util.Arrays;
import java.util.List;

public class IteratorPattern {

    public static void main(String[] args) {
        List<Book> books  = Arrays.asList(
                new Book("1", "Science"),
                new Book("2", "Maths"),
                new Book("3", "GK"),
                new Book("4", "Computer")
        );

        Aggregator library = new Library(books);
        Iterator iterator = library.getIterator();

        while (iterator.hasNext()) {
            Book next = (Book) iterator.next();
            System.out.println(next.getName());
        }
    }
}

interface Iterator {

    boolean hasNext();

    Object next();
}

interface Aggregator {

    public Iterator getIterator();
}

class Library implements Aggregator {

    List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    @Override
    public Iterator getIterator() {
        return new BookIterator(books);
    }
}

class BookIterator implements Iterator {

    private List<Book> bookList;
    private int index = 0;

    public BookIterator(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public boolean hasNext() {
        return index < bookList.size();
    }

    @Override
    public Object next() {
       if (hasNext()) {
           return bookList.get(index++);
       }

       return null;
    }
}

class Book {

    private String bookNo;
    private String name;

    public Book(String bookNo, String name) {
        this.bookNo = bookNo;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getBookNo() {
        return bookNo;
    }
}