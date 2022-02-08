package com.razorpay.service;

import com.razorpay.model.Row;

import java.util.List;
import java.util.Map;

public interface TableManager {
    void insert(String database, String tableName, Row row);
    void printAll(String database, String tableName);
    void printAllWithFilter(String database, String tableName, Predicate predicate, Map<String, Object> expectedResult);
}
