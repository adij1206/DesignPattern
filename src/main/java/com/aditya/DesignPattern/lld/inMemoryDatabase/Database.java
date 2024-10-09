package com.aditya.DesignPattern.lld.inMemoryDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

    private String databaseName;
    private Map<String, Table> tableMap;

    public Database(String databaseName) {
        this.databaseName = databaseName;
        this.tableMap = new HashMap<>();
    }

    public Table getTable(String tableName) {
        return tableMap.get(tableName);
    }

    public void deleteTable(String tableName) {
        this.tableMap.remove(tableName);
    }

    public void createTable(String tableName, List<Column> columnList) {
        if (!checkIfTableExists(tableName)) {
            Table table = new Table(tableName, columnList);
            tableMap.put(tableName, table);
        }
    }

    public void addRow(String tableName, Map<Column, Object> columnObjectMap) {
        if (!checkIfTableExists(tableName)) {
            System.out.println("Row cannot be added");
            return;
        }

        Table table = tableMap.get(tableName);
        table.insertRow(columnObjectMap);
        tableMap.put(tableName, table);
    }

    public void printAllRow(String tableName) {
        if (!checkIfTableExists(tableName)) {
            System.out.println("Rows cannot be pribted");
            return;
        }

        Table table = tableMap.get(tableName);
        table.printAllRow();
    }

    public List<Row> fetchByColumnName(String tableName, Column column, Object value) {
        if (!checkIfTableExists(tableName)) {
            System.out.println("Columns cannot be fetched");
            return null;
        }

        Table table = tableMap.get(tableName);
        return table.fetchByColumn(column, value);
    }

    public void truncateTable(String tableName) {
        if (!checkIfTableExists(tableName)) {
            return;
        }

        Table table = tableMap.get(tableName);
        table.truncateTable();
    }

    public void updateColumn(String tableName, String rowId, Map<Column, Object> columnObjectMap) {
        if (!checkIfTableExists(tableName)) {
            System.out.println("Update Column is not done!");
            return;
        }

        Table table = tableMap.get(tableName);
        table.updateRow(rowId, columnObjectMap);
    }

    private boolean checkIfTableExists(String tableName) {
        if (!tableMap.containsKey(tableName)) {
            System.out.println("Table does not exists");
            return false;
        }

        return true;
    }
}
