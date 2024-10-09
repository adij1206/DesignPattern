package com.aditya.DesignPattern.lld.inMemoryDatabase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Demo {

    public static void main(String[] args) {
        // Create Database
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.createDatabase("db");

        Database db = databaseManager.getDatabase("db");

        // Creating Column

        Column column1 = new Column("column1", ColumnType.INT.name());
        Column column2 = new Column("column2", ColumnType.STRING.name());
        Column column3 = new Column("column3", ColumnType.STRING.name());
        Column column4 = new Column("column4", ColumnType.INT.name());

        db.createTable("table1", Arrays.asList(column1, column2, column3, column4));
        Table table1 = db.getTable("table1");

        Map<Column, Object> columnObjectMap = new HashMap<>();
        columnObjectMap.put(column1, 1);
        columnObjectMap.put(column2, "Abc");
        columnObjectMap.put(column3, "Abd");
        columnObjectMap.put(column4, 5);

        db.addRow(table1.getTableName(), columnObjectMap);

        Map<Column, Object> columnObjectMap1 = new HashMap<>();
        columnObjectMap1.put(column1, 2);
        columnObjectMap1.put(column2, "Abd");
        columnObjectMap1.put(column3, "Abe");
        columnObjectMap1.put(column4, 6);
        db.addRow(table1.getTableName(), columnObjectMap1);

        Map<Column, Object> columnObjectMap2 = new HashMap<>();
        columnObjectMap2.put(column1, 2);
        columnObjectMap2.put(column2, "Abd");
        columnObjectMap2.put(column3, "Abe");
        columnObjectMap2.put(column4, 6);
        db.addRow(table1.getTableName(), columnObjectMap2);

        db.printAllRow(table1.getTableName());

        System.out.println(db.fetchByColumnName(table1.getTableName(), column1, 2));

        Map<Column, Object> columnObjectMap3 = new HashMap<>();
        columnObjectMap3.put(column1, 3);
        columnObjectMap3.put(column2, "Abd");
        columnObjectMap3.put(column4, 6);
        //db.addRow(table1.getTableName(), columnObjectMap3);

        db.updateColumn(table1.getTableName(), "2", columnObjectMap3);

        System.out.println(db.fetchByColumnName(table1.getTableName(), column1, 3));

        db.truncateTable(table1.getTableName());
        db.deleteTable(table1.getTableName());

        System.out.println(db.getTable(table1.getTableName()));

        databaseManager.removeDatabase("db");
        System.out.println(databaseManager.getDatabase("db"));
    }
}
