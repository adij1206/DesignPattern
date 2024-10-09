package com.aditya.DesignPattern.lld.inMemorySearchEngine;

import java.util.List;

public interface DocumentSearch {

    List<Document> search(Category category, String searchTerm);
}
