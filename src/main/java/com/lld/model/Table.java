package com.lld.model;

import lombok.Data;

import java.util.Map;

@Data
public class Table {
    private String name;
    private Map<String, Row> data;
    private Map<String, Column> columns;
}
