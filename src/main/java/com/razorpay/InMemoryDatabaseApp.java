package com.razorpay;

import com.razorpay.model.*;
import com.razorpay.repository.DatabaseRepository;
import com.razorpay.service.DatabaseManager;
import com.razorpay.service.impl.DatabaseManagerImpl;
import com.razorpay.service.impl.EqualityPredicate;
import com.razorpay.service.impl.TableManagerImpl;

import java.util.*;

public class InMemoryDatabaseApp {
    public static void main(String[] args) {
        DatabaseRepository databaseRepository = new DatabaseRepository();
        DatabaseManager databaseManager = new DatabaseManagerImpl(databaseRepository);
        TableManagerImpl tableManager = new TableManagerImpl(databaseRepository);
        
        // Create database

        databaseManager.createDatabase("Razorpay");

        // Create tables

        List<Column> columns = new ArrayList<>();
        Column column1 = new Column();
        column1.setColumnName("userId");
        column1.setDataType(DataType.INT);


        Column column2 = new Column();
        column2.setColumnName("userName");
        column2.setDataType(DataType.STRING);
        column2.setConstraint(new LengthBasedConstraint(10));

        columns.add(column1);
        columns.add(column2);

        databaseManager.createTable("Razorpay", "User", columns);

        Row row = new Row();
        Map<String, Cell> rowData = new HashMap<>();
        rowData.put("userId", new Cell(true, 1));
        rowData.put("userName", new Cell(false, "User101"));
        row.setRowData(rowData);

        tableManager.insert("Razorpay", "User", row);

        Row row2 = new Row();
        Map<String, Cell> rowData2 = new HashMap<>();
        rowData2.put("userId", new Cell(true, 2));
        rowData2.put("userName", new Cell(false, "User102"));
        row2.setRowData(rowData2);

        tableManager.insert("Razorpay", "User", row2);


        tableManager.printAll("Razorpay", "User");

        Map<String, Object> filterMap = new HashMap<>();
        filterMap.put("userId", 1);
        EqualityPredicate predicate = new EqualityPredicate();

        System.out.println("************");
        tableManager.printAllWithFilter("Razorpay", "User", predicate, filterMap);

        Row row3 = new Row();
        Map<String, Cell> rowData3 = new HashMap<>();
        rowData3.put("userId", new Cell(true, 2));
        rowData3.put("userName", new Cell(false, "Usersddssddsdscjhsdhjdshjdshjhjdshjdshjhjdsjhds102"));
        row3.setRowData(rowData3);
        tableManager.insert("Razorpay", "User", row3);

        databaseManager.deleteTable("Razorpay", "User");
    }
}
