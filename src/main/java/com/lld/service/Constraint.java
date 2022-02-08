package com.lld.service;

import com.lld.model.Row;

public interface Constraint {
    boolean isValid(Row row);
}
