package com.lld.model;

import com.lld.service.Constraint;
import lombok.Data;

@Data
public class Column {
    private String columnName;
    private DataType dataType;
    private Constraint constraint;
}
