package com.rev.jdbc;

import java.sql.*;

public class JDBCDemoUpdate {

    public static void main(String[] args) {

        try {

            Class.forName("org.postgresql.Driver");

            try (Connection connection = DriverManager.getConnection(System.getenv("DB_URL"),
                    System.getenv("DB_USER"), System.getenv("DB_PWD"))) {

                String sql = "UPDATE employees SET salary = ? WHERE first_name = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setDouble(1, 200000);
                statement.setString(2, "Bob");

                int rowsAffected = statement.executeUpdate();
                System.out.println("Success, " + rowsAffected + " rows affected");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
