package com.rev.jdbc;

import java.sql.*;

public class JDBCDemoFirst {

    public static void main(String[] args) {

        // STEP 1 - Load the Driver (optional)
        try {
            Class.forName("org.postgresql.Driver");

            //STEP 2 - Create a connection
            try (Connection connection =
                         DriverManager.getConnection(System.getenv("DB_URL"),
                                 System.getenv("DB_USER"), System.getenv("DB_PWD"))) {

                //STEP 3: Create statement object
                String query = "SELECT * FROM employees";
                PreparedStatement statement = connection.prepareStatement(query);

                //STEP 4: Collect results in ResultSet
                ResultSet resultSet = statement.executeQuery();

                //STEP 5: Iterate over and process resultSet
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("emp_id") + " " +
                            resultSet.getString(3) + " " +
                            resultSet.getDouble("salary"));
                }

                //STEP 6 - close the connection
                //connection.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
