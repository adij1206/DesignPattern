package com.aditya.DesignPattern.lld.googleDoc;

import lombok.Data;

import java.util.UUID;

@Data
public class Document {

    private String id;
    private String owner;
    private String content;
    private Long createdTimeStamp;
    private int latestVersionHistory;
    private Long updatedTimeStamp;
    private boolean isGlobal;

    public Document(String owner) {
        this.id = UUID.randomUUID().toString();
        this.owner = owner;
        this.createdTimeStamp = System.currentTimeMillis();
        this.updatedTimeStamp = System.currentTimeMillis();
        this.latestVersionHistory = 0;
        this.isGlobal = false;
    }
}
