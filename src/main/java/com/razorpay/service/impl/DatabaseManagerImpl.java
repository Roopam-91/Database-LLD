package com.razorpay.service.impl;

import com.razorpay.model.Column;
import com.razorpay.model.Database;
import com.razorpay.model.Table;
import com.razorpay.repository.DatabaseRepository;
import com.razorpay.service.DatabaseManager;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class DatabaseManagerImpl implements DatabaseManager {
    private final DatabaseRepository databaseRepository;
    public DatabaseManagerImpl(DatabaseRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }
    @Override
    public void createDatabase(String databaseName) {
        Database database = new Database(databaseName, new ConcurrentHashMap<>());
        if(Objects.isNull(databaseRepository.getDatabases())) {
            databaseRepository.setDatabases(new ConcurrentHashMap<>());
        }
        databaseRepository.getDatabases().put(databaseName, database);
    }

    @Override
    public void createTable(String databaseName, String tableName, List<Column> columnList) {
        Table table = new Table();
        table.setName(tableName);
        table.setColumns(columnList.stream().collect(Collectors.toMap(Column::getColumnName, column -> column, (first, second) -> second)));
        table.setData(new ConcurrentHashMap<>());
        Database database = databaseRepository.getDatabases().get(databaseName);
        if(Objects.isNull(database.getTables())) {
            database.setTables(new ConcurrentHashMap<>());
        }
        database.getTables().put(tableName, table);
    }

    @Override
    public void deleteTable(String databaseName, String table) {
        Database database = databaseRepository.getDatabases().get(databaseName);
        database.getTables().remove(table);
        System.out.println("Table "+databaseName +"."+table+" Removed Successfully");
    }
}
