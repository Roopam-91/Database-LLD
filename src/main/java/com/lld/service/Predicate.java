package com.lld.service;

import com.lld.model.Row;

import java.util.Map;

public interface Predicate {
    boolean isMatching(Row row,  Map<String, Object> expected);
}
