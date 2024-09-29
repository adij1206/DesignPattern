package com.aditya.DesignPattern.lld.stackOverFlow;

public class Comment {

    private int id;
    private String content;
    private User author;
    private Long creationDate;

    public Comment(String content, User author) {
        this.id = generateId();
        this.content = content;
        this.author = author;
        this.creationDate = System.currentTimeMillis();
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }
}
