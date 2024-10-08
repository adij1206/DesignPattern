package com.aditya.DesignPattern.lld.googleDoc;

import java.util.HashMap;
import java.util.Map;

public class DocumentService {

    private Map<String, Document> documentMap;

    public DocumentService() {
        this.documentMap = new HashMap<>();
    }

    public void addDocument(Document document) {
        this.documentMap.put(document.getId(), document);
    }

    public Document getDocumentById(String documentId) {
        return documentMap.get(documentId);
    }

    public synchronized Document updateDocumentContent(String content, String documentId) {
        Document document = getDocumentById(documentId);
        document.setContent(content);
        document.setLatestVersionHistory(document.getLatestVersionHistory() + 1);
        document.setUpdatedTimeStamp(System.currentTimeMillis());
        documentMap.put(documentId, document);
        System.out.println("Updated Document Content, version history" + document.getLatestVersionHistory());
        return document;
    }

    public synchronized void makeDocumentGlobal(String documentId) {
        Document document = documentMap.get(documentId);
        document.setGlobal(true);

        System.out.println("Made Document Public");

        documentMap.put(documentId, document);
    }

    public void deleteDocument(String documentId) {
        documentMap.remove(documentId);
        System.out.println("Deleted Document");

    }
}
