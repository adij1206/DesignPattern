package com.aditya.DesignPattern.lld.inMemorySearchEngine;

import lombok.Data;

import java.util.UUID;

@Data
public class Document {

    private String documentId;
    private String title;
    private String author;
    private String content;
    private Long createdTimeStamp;

    public Document(String title, String author, String content) {
        this.documentId = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
        this.content = content;
        this.createdTimeStamp = System.currentTimeMillis();
    }
}
