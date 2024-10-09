package com.aditya.DesignPattern.lld.inMemorySearchEngine;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchEngine {

    private static SearchEngine instance;
    private Map<String, Category> categoryMap;

    private SearchEngine() {
        categoryMap = new HashMap<>();
    }

    public synchronized static SearchEngine getInstance() {
        if (instance == null) {
            instance = new SearchEngine();
        }
        return instance;
    }

    public void createCategory(String name) {
        Category category = new Category(name);
        categoryMap.put(name, category);
    }

    public Category getCategory(String name) {
        return categoryMap.get(name);
    }

    public void addDocument(String categoryName, String title, String author, String content) {
        Category category = categoryMap.get(categoryName);
        if (category == null) {
            System.out.println("Cateogry not found");
            return;
        }

        Document document = new Document(title, author, content);
        category.addDocument(document);
    }

    public List<Document> searchDocument(String categoryName, String query, String searchType) {
        Category category = categoryMap.get(categoryName);
        if (category == null) {
            System.out.println("Cateogry not found");
            return Collections.EMPTY_LIST;
        }

        DocumentSearch documentSearch = SearchFactory.createDocumentSearch(searchType);
        return documentSearch.search(category, query);
    }
}
