package com.aditya.DesignPattern.lld.inMemorySearchEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Category {

    private String name;
    private List<Document> documentList;
    private InvertedIndex invertedIndex;

    public Category(String name) {
        this.name = name;
        this.documentList = new ArrayList<>();
        this.invertedIndex = new InvertedIndex();
    }

    public void addDocument(Document document) {
        this.documentList.add(document);
        updateInvertedIndex(document);
    }

    private void updateInvertedIndex(Document document) {
        invertedIndex.addDocument(document);
    }

    public Set<Document> getDocumentListFromInvertedIndex(String word) {
        return invertedIndex.getDocumentByWord(word);
    }

    public List<Document> getAllDocument() {
        return documentList;
    }
}
