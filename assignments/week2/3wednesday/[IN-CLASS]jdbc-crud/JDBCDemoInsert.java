package com.rev.jdbc;

import java.sql.*;

public class JDBCDemoInsert {

    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");

            try ( Connection connection = DriverManager.getConnection(System.getenv("DB_URL"),
                    System.getenv("DB_USER"), System.getenv("DB_PWD"));) {

                String query = "INSERT INTO employees(emp_id, first_name, last_name, department, salary) VALUES (?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1,6);
                statement.setString(2, "Seoky");
                statement.setString(3, "Ducky");
                statement.setString(4, "Cool Tech Unit");
                statement.setDouble(5, 1000000.99);

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
