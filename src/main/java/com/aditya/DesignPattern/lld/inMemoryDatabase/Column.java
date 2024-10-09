package com.aditya.DesignPattern.lld.inMemoryDatabase;

import lombok.Data;

@Data
public class Column {

    private String columnName;
    private String columnsType;

    public Column(String columnName, String columnsType) {
        this.columnName = columnName;
        this.columnsType = columnsType;
    }
}
