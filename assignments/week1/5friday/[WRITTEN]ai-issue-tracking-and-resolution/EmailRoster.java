package com.cohort.ai;

// Step 1: Original non-reviewed code
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmailRoster {
    private List<String> emails = new ArrayList<>();

    // Insecure query builder: vulnerable to SQL Injection
    public void saveToDatabase(Connection conn, String email) throws Exception {
        Statement stmt = conn.createStatement();
        String sql = "INSERT INTO users (email) VALUES ('" + email + "')";
        stmt.executeUpdate(sql); // LINE 12: SQL Injection point!
    }

    public void addEmail(String email) {
        emails.add(email); // Allows duplicate emails
    }
}

