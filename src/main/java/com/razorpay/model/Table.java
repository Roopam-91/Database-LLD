package com.razorpay.model;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class Table {
    private String name;
    private Map<String, Row> data;
    private Map<String, Column> columns;
}
