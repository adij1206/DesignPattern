package com.aditya.DesignPattern.lld.inMemorySearchEngine;

import java.util.ArrayList;
import java.util.List;

public class SubStringDocumentSearch implements DocumentSearch {

    @Override
    public List<Document> search(Category category, String searchTerm) {
        List<Document> documents = new ArrayList<>();

        for (Document document : category.getAllDocument()) {
            if (document.getContent().toLowerCase().contains(searchTerm.toLowerCase())) {
                documents.add(document);
            }
        }

        return documents;
    }
}
