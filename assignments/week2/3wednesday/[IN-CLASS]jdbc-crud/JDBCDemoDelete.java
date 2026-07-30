package com.rev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class JDBCDemoDelete {

    public static void main(String[] args) {

        try {

            Class.forName("org.postgresql.Driver");

            try (Connection connection = DriverManager.getConnection(System.getenv("DB_URL"),
                    System.getenv("DB_USER"), System.getenv("DB_PWD"));) {

                String sql = "DELETE FROM employees WHERE emp_id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, 6);

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
