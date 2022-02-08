package com.lld.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
public class Cell {
    private boolean isPrimaryKey;
    private Object data;
}
