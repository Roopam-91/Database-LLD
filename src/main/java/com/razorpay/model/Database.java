package com.razorpay.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class Database {
    private String name;
    private Map<String, Table> tables;
}
