package com.aditya.DesignPattern.lld.inMemorySearchEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UnOrderedDocumentSearch implements DocumentSearch {

    @Override
    public List<Document> search(Category category, String searchTerm) {
        String[] words = searchTerm.toLowerCase().split(" ");

        Set<Document> documents = category.getDocumentListFromInvertedIndex(words[0]);

        for (int i = 1; i < words.length; i++) {
            documents.retainAll(category.getDocumentListFromInvertedIndex(words[i]));
        }

        return new ArrayList<>(documents);
    }
}
