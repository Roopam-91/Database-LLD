package com.razorpay.service;

import com.razorpay.model.Row;

import java.util.Map;

public interface Predicate {
    boolean isMatching(Row row,  Map<String, Object> expected);
}
