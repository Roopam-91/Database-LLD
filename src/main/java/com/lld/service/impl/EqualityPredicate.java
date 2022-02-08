package com.lld.service.impl;

import com.lld.model.Row;
import com.lld.service.Predicate;

import java.util.Map;

public class EqualityPredicate implements Predicate {
    @Override
    public boolean isMatching(Row row, Map<String, Object> expected) {
        for(String key: row.getRowData().keySet()) {
            if (expected.containsKey(key) && !row.getRowData().get(key).getData().equals(expected.get(key))) {
                return false;
            }
        }
        return true;
    }
}
