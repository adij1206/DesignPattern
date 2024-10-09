package com.aditya.DesignPattern.lld.inMemoryDatabase;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Table {

    private String tableName;
    private Map<String, Column> columnMap;
    private Map<String, Row> rows;
    private Integer autoIncrement;

    public Table(String tableName, List<Column> columns) {
        this.tableName = tableName;
        this.rows = new HashMap<>();
        this.columnMap = new HashMap<>();
        this.autoIncrement = 0;

        populateColumnData(columns);
    }

    public void insertRow(Map<Column, Object> columnObjectMap) {
        for (Column column : columnObjectMap.keySet()) {
            if (!checkIfColumnExists(column.getColumnName())) {
                return;
            }
        }
        Map<Column, Object> columnData = new HashMap(columnObjectMap);
        Row row = new Row(generatedAutoIncrement().toString(), columnData);
        rows.put(row.getId(), row);
        System.out.println("Row has been added : " + row.getId());
    }

    public void truncateTable() {
        this.rows.clear();
    }

    public List<Row> fetchByColumn(Column column, Object value) {
        List<Row> rowList = new ArrayList<>();
        for (Row row : rows.values()) {
            Object rowData = row.getColumnValuesMap().get(column);
            if (rowData.equals(value)) {
                rowList.add(row);
            }
        }

        return rowList;
    }

    public void printAllRow() {
        for (String columnName : columnMap.keySet()) {
            System.out.print(columnName + "|");
        }
        System.out.println();

        for (Row row : rows.values()) {
            Map<Column, Object> columnValuesMap = row.getColumnValuesMap();
            for (Object object : columnValuesMap.values()) {
                System.out.print(object + " ");
            }
        }
    }

    public void updateRow(String rowId, Map<Column, Object> columnObjectMap) {
        for (Column column : columnObjectMap.keySet()) {
            if (!checkIfColumnExists(column.getColumnName())) {
                System.out.println("Columns Does not exists!");
                return;
            }
        }

        Row row = rows.get(rowId);

        for (Map.Entry<Column, Object> columnObjectEntry : columnObjectMap.entrySet()) {
            row.getColumnValuesMap().put(columnObjectEntry.getKey(), columnObjectEntry.getValue());
        }
    }

    private void populateColumnData(List<Column> columns) {
        for (Column column : columns) {
            columnMap.put(column.getColumnName(), column);
        }
    }

    private synchronized Integer generatedAutoIncrement() {
        return ++autoIncrement;
    }

    private boolean checkIfColumnExists(String columnsName) {
        if (!columnMap.containsKey(columnsName)) {
            System.out.println("Columns does not exists!");
            return false;
        }

        return true;
    }
}
