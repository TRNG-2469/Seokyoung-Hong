package com.cohort.ai;

import java.sql.Connection;
import java.sql.PreparedStatement; // 1. Switch to PreparedStatement
import java.sql.SQLException;
import java.util.HashSet; // 2. Switch to HashSet to prevent duplicates
import java.util.Set;

public class EmailRosterClean {
    // HashSet guarantees email uniqueness at O(1) time complexity
    private Set<String> emails = new HashSet<>();

    /**
     * Safely saves user email to database.
     * Uses Try-with-Resources to prevent connection leaks, and PreparedStatement to block SQL injections.
     */
    public void saveToDatabase(Connection conn, String email) throws SQLException {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format.");
        }

        String sql = "INSERT INTO users (email) VALUES (?)"; // Parameterized placeholder

        // 3. Try-with-resources automatically closes PreparedStatement on block exit
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email.trim()); // 4. Safe binding prevents SQL injections
            stmt.executeUpdate();
            System.out.println("[DB-SAVE] Successfully saved email: " + email);
        }
    }

    public void addEmail(String email) {
        if (email != null) {
            // Set will automatically ignore duplicates
            boolean wasAdded = emails.add(email.trim().toLowerCase());
            if (wasAdded) {
                System.out.println("[ROSTER] Added email: " + email);
            } else {
                System.out.println("[ROSTER] Skipped duplicate email: " + email);
            }
        }
    }

    public Set<String> getEmails() {
        return this.emails;
    }
}