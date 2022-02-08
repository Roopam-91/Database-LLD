package com.razorpay.service;

import com.razorpay.model.Column;

import java.util.List;

public interface DatabaseManager {
    void createDatabase(String databaseName);
    void createTable(String databaseName, String table, List<Column> columnList);
    void deleteTable(String databaseName, String table);
}
