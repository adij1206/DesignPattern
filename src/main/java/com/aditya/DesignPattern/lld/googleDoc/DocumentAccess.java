package com.aditya.DesignPattern.lld.googleDoc;

import lombok.Data;

@Data
public class DocumentAccess {

    private String id;
    private String userId;
    private String documentId;
    private String accessLevel;

    public DocumentAccess(String userId, String documentId, String accessLevel) {
        this.id = documentId + "_" + userId;
        this.userId = userId;
        this.documentId = documentId;
        this.accessLevel = accessLevel;
    }
}