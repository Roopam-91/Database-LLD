package com.lld.repository;

import com.lld.model.Database;
import lombok.Data;
import java.util.Map;

@Data
public class DatabaseRepository {
    private Map<String, Database> databases;
}
