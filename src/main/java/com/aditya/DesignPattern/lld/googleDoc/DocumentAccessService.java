package com.aditya.DesignPattern.lld.googleDoc;

import java.util.HashMap;
import java.util.Map;

public class DocumentAccessService {

    private Map<String, DocumentAccess> documentAccessMap;

    public DocumentAccessService() {
        this.documentAccessMap = new HashMap<>();
    }

    public void addDocument(String documentId, String userId) {
        DocumentAccess documentAccess = new DocumentAccess(userId, documentId, AccessLevel.ADMIN.name());
        this.documentAccessMap.put(documentAccess.getId(), documentAccess);
    }

    public DocumentAccess getDocumentAccessById(String documentAccessId) {
        return documentAccessMap.get(documentAccessId);
    }

    public DocumentAccess getDocumentAccessByDocumentIdAndUserId(String documentId, String userId) {
        String key = documentId + "_" + userId;

        return documentAccessMap.get(key);
    }

    public synchronized void updateDocumentAccessLevel(String documentId, String userId, AccessLevel accessLevel) {
        String key = documentId + "_" + userId;

        DocumentAccess documentAccess = documentAccessMap.getOrDefault(
                key, new DocumentAccess(userId, documentId, accessLevel.name()));
        documentAccess.setAccessLevel(accessLevel.name());

        documentAccessMap.put(key, documentAccess);
        System.out.println("Updated AccessLevel");
    }
}
