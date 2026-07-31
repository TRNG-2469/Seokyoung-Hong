package com.rev.jdbc.dao;

import com.rev.jdbc.model.Employee;
import com.rev.utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void create(Employee e) {
        String insertQuery = "INSERT INTO employees VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getInstance().getConnection()){

            PreparedStatement ps = connection.prepareStatement(insertQuery);
            ps.setInt(1, e.getEmployeeId());
            ps.setString(2, e.getFirstName());
            ps.setString(3, e.getLastName());
            ps.setString(4, e.getDepartment());
            ps.setDouble(5, e.getSalary());

            ps.executeUpdate();

        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public void update(Employee e) {
        String updateQuery = "UPDATE employees SET first_name = ?, last_name = ?, department = ?, salary = ? WHERE emp_id = ?";

        try (Connection connection = ConnectionFactory.getInstance().getConnection()){

            PreparedStatement ps = connection.prepareStatement(updateQuery);
            ps.setInt(5, e.getEmployeeId());
            ps.setString(1, e.getFirstName());
            ps.setString(2, e.getLastName());
            ps.setString(3, e.getDepartment());
            ps.setDouble(4, e.getSalary());

            ps.executeUpdate();

        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public void delete(int employeeId) {
        String deleteQuery = "DELETE FROM employees WHERE emp_id = ?";

        try (Connection connection = ConnectionFactory.getInstance().getConnection()){

            PreparedStatement ps = connection.prepareStatement(deleteQuery);
            ps.setInt(1, employeeId);

            ps.executeUpdate();

        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public Employee findById(int employeeId) {
        String findQuery = "SELECT * FROM employees WHERE emp_id = ?";

        try (Connection connection = ConnectionFactory.getInstance().getConnection()){

            PreparedStatement ps = connection.prepareStatement(findQuery);
            ps.setInt(1, employeeId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int eId = rs.getInt("emp_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                return new Employee(eId, firstName, lastName, department, salary);
            }

        } catch (SQLException exc) {
            exc.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Employee> findAll() {
        String findQuery = "SELECT * FROM employees";

        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement ps = connection.prepareStatement(findQuery);
            ResultSet rs = ps.executeQuery();

            List<Employee> employeeList = new ArrayList<>();

            while (rs.next()) {
                int employeeId = rs.getInt("emp_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                Employee e = new Employee(employeeId, firstName, lastName, department, salary);
                employeeList.add(e);
            }

            return employeeList;

        } catch (SQLException exc) {
            exc.printStackTrace();
        }

        return null;
    }
}
