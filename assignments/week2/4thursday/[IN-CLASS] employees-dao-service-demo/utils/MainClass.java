package com.rev.utils;

import com.rev.jdbc.service.EmployeeService;
import com.rev.jdbc.service.EmployeeServiceImpl;

public class MainClass {

    public static void main (String[] args) {

        EmployeeService service = new EmployeeServiceImpl();

        /*
        //Create
        Employee e = new Employee(6, "Seoky", "Ducky", "Duck Watching", 1000000);
        service.create(e);

        //Update
        Employee e = new Employee(6, "SeokyCHANGED", "DuckyCHANGED", "Duck WatchingCHANGED", 1);
        service.update(e);

        //Delete
        int employeeId = 6;
        service.delete(employeeId);

        //Find by Id
        int employeeId = 5;
        System.out.println(service.findById(employeeId));*/

        //Find all
        System.out.println(service.findAll());
    }
}
