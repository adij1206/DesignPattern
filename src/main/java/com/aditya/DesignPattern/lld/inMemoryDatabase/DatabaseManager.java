package com.aditya.DesignPattern.lld.inMemoryDatabase;

import java.util.HashMap;
import java.util.Map;

public class DatabaseManager {

    private Map<String, Database> databaseMap;

    public DatabaseManager() {
        this.databaseMap = new HashMap<>();
    }

    public void createDatabase(String databaseName) {
        Database database = new Database(databaseName);
        databaseMap.put(databaseName, database);
    }

    public Database getDatabase(String databaseName) {
        return databaseMap.get(databaseName);
    }

    public void removeDatabase(String databaseName) {
        databaseMap.remove(databaseName);
    }
}
