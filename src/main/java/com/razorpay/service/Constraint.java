package com.razorpay.service;

import com.razorpay.model.Row;

public interface Constraint {
    boolean isValid(Row row);
}
