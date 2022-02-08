package com.razorpay.repository;

import com.razorpay.model.Database;
import lombok.Data;
import java.util.Map;

@Data
public class DatabaseRepository {
    private Map<String, Database> databases;
}
