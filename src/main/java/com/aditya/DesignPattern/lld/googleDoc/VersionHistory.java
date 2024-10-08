package com.aditya.DesignPattern.lld.googleDoc;

import lombok.Data;

import java.util.UUID;

@Data
public class VersionHistory {

    private String id;
    private int versionHistory;
    private String content;
    private String userId;
    private String documentId;

    public VersionHistory(int versionHistory, String content, String userId, String documentId) {
        this.id = UUID.randomUUID().toString();
        this.versionHistory = versionHistory;
        this.content = content;
        this.userId = userId;
        this.documentId = documentId;
    }
}
