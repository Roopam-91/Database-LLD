package com.lld.service;

import com.lld.model.Column;

import java.util.List;

public interface DatabaseManager {
    void createDatabase(String databaseName);
    void createTable(String databaseName, String table, List<Column> columnList);
    void deleteTable(String databaseName, String table);
}
