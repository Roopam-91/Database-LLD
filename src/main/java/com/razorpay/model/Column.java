package com.razorpay.model;

import com.razorpay.service.Constraint;
import lombok.Data;

@Data
public class Column {
    private String columnName;
    private DataType dataType;
    private Constraint constraint;
}
