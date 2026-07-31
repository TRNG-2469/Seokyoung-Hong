package com.rev.jdbc.service;

import com.rev.jdbc.dao.EmployeeDAO;
import com.rev.jdbc.dao.EmployeeDAOImpl;
import com.rev.jdbc.model.Employee;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {


    @Override
    public void create(Employee e) {
        if (e == null) {
            throw new IllegalArgumentException("Cannot be null");
        }

        if (e.getFirstName() == null || e.getFirstName().isEmpty() ||
            e.getLastName() == null || e.getLastName().isEmpty() ||
            e.getDepartment() == null || e.getDepartment().isEmpty() ||
            e.getSalary() < 0 || e.getEmployeeId() < 0) {
            throw new IllegalArgumentException("Invalid Employee");
        }

        EmployeeDAO dao = new EmployeeDAOImpl();
        dao.create(e);
    }

    @Override
    public void update(Employee e) {
        if (e == null) {
            throw new IllegalArgumentException("Cannot be null");
        }

        if (e.getFirstName() == null || e.getFirstName().isEmpty() ||
                e.getLastName() == null || e.getLastName().isEmpty() ||
                e.getDepartment() == null || e.getDepartment().isEmpty() ||
                e.getSalary() < 0 || e.getEmployeeId() < 0) {
            throw new IllegalArgumentException("Invalid Employee");
        }

        EmployeeDAO dao = new EmployeeDAOImpl();
        dao.update(e);
    }

    @Override
    public void delete(int employeeId) {
        if (employeeId < 0) {
            throw new IllegalArgumentException("Cannot be negative");
        }

        EmployeeDAO dao = new EmployeeDAOImpl();
        dao.delete(employeeId);
    }

    @Override
    public Employee findById(int employeeId) {
        if (employeeId < 0) {
            throw new IllegalArgumentException("Cannot be null");
        }

        EmployeeDAO dao = new EmployeeDAOImpl();
        return dao.findById(employeeId);
    }

    @Override
    public List<Employee> findAll() {
        EmployeeDAO dao = new EmployeeDAOImpl();
        return dao.findAll();
    }
}
