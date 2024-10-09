package com.aditya.DesignPattern.lld.inMemorySearchEngine;

public class SearchFactory {

    public static DocumentSearch createDocumentSearch(String searchType) {
        return switch (searchType) {
            case "UNORDERED" -> new UnOrderedDocumentSearch();
            case "SUBSTRING" -> new SubStringDocumentSearch();
            default -> null;
        };

    }
}
