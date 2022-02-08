package com.lld.model;


import com.lld.service.Constraint;

public class LengthBasedConstraint implements Constraint {
private int lengthAllowed;
public LengthBasedConstraint(int lengthAllowed) {
    this.lengthAllowed = lengthAllowed;
}
    @Override
    public boolean isValid(Row row) {
        Cell cell = row.getRowData().values().stream()
                .filter(record -> ((record.getData() instanceof String) && record.getData().toString().length() > lengthAllowed))
                .findFirst().orElse(null);
        if(cell == null) {
            return true;
        } else {
            return false;
        }
    }
}
