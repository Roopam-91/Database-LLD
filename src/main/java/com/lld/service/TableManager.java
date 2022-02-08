package com.lld.service;

import com.lld.model.Row;

import java.util.Map;

public interface TableManager {
    void insert(String database, String tableName, Row row);
    void printAll(String database, String tableName);
    void printAllWithFilter(String database, String tableName, Predicate predicate, Map<String, Object> expectedResult);
}
