package com.aditya.DesignPattern.lld.inMemoryDatabase;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Row {

    private String id;
    private Map<Column, Object> columnValuesMap;

    public Row(String id, Map<Column, Object> columnValuesMap) {
        this.id =id;
        this.columnValuesMap = columnValuesMap;
    }
}
