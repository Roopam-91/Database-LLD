package com.lld.model;

import lombok.Data;

import java.util.Map;

@Data
public class Row {
    private Map<String, Cell> rowData;
}
