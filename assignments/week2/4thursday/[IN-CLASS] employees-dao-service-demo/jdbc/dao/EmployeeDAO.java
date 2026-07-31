package com.rev.jdbc.dao;

import com.rev.jdbc.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    void create(Employee e);
    void update(Employee e);
    void delete(int employeeId);

    Employee findById(int employeeId);
    List<Employee> findAll();

}
