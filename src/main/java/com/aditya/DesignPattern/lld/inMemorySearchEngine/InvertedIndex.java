package com.aditya.DesignPattern.lld.inMemorySearchEngine;

import java.util.*;

public class InvertedIndex {

    private Map<String, Set<Document>> wordDocumentMapping;

    public InvertedIndex() {
        wordDocumentMapping = new HashMap<>();
    }

    public void addDocument(Document document) {
        String[] wordArray = document.getContent().toLowerCase().split("\\W+");

        for (String word : wordArray) {
            if (!wordDocumentMapping.containsKey(word)) {
                HashSet<Document> set = new HashSet<>();
                set.add(document);
                wordDocumentMapping.put(word, set);
            } else {
                wordDocumentMapping.get(word).add(document);
            }
        }
    }

    public Set<Document> getDocumentByWord(String word) {
        return wordDocumentMapping.get(word);
    }
}
