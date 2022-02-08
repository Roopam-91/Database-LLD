package com.razorpay.service.impl;

import com.razorpay.model.Cell;
import com.razorpay.model.Row;
import com.razorpay.model.Table;
import com.razorpay.repository.DatabaseRepository;
import com.razorpay.service.Constraint;
import com.razorpay.service.Predicate;
import com.razorpay.service.TableManager;

import java.util.Map;
import java.util.Objects;


public class TableManagerImpl implements TableManager {
private DatabaseRepository databaseRepository;
   public TableManagerImpl(DatabaseRepository databaseRepository) {
    this.databaseRepository = databaseRepository;
   }
    @Override
    public void insert(String database, String tableName, Row row) {
        Table table = databaseRepository.getDatabases().get(database).getTables().get(tableName);
        Cell primaryKey = row.getRowData().values().stream().filter(Cell::isPrimaryKey).findFirst()
                .orElseThrow(() -> new RuntimeException("No primary key found"));
        validateConstraint(row, table);
        table.getData().put(primaryKey.getData().toString(), row);
    }

    private void validateConstraint(Row row, Table table) {
        row.getRowData().keySet().forEach(columnName -> {
            if(Objects.isNull(table.getColumns().get(columnName))) {
                throw new RuntimeException("Invalid column entered " +columnName);
            }
            Constraint constraint = table.getColumns().get(columnName).getConstraint();
            if(!Objects.isNull(constraint) && !constraint.isValid(row)) {
                throw new RuntimeException("Data validation failed for column "+columnName + " constraint "+ constraint.getClass().getName());
            }
        });
    }

    @Override
    public void printAll(String database, String tableName) {
        databaseRepository.getDatabases().get(database).getTables().get(tableName).getData().values()
                .forEach(row -> {
                    Map<String, Cell> rowData =  row.getRowData();
                    rowData.forEach((key, value) -> System.out.print (key + " --> " + value.getData() + "|"));
                    System.out.println();
                });
    }

    @Override
    public void printAllWithFilter(String database, String tableName, Predicate predicate, Map<String, Object> expectedResult) {
        databaseRepository.getDatabases().get(database).getTables().get(tableName).getData().values()
                .stream().filter(row -> predicate.isMatching(row, expectedResult))
                .forEach(row -> {
                    Map<String, Cell> rowData =  row.getRowData();
                    rowData.forEach((key, value) -> System.out.print (key + " --> " + value.getData() + "|"));
                    System.out.println();
                });
    }
}
