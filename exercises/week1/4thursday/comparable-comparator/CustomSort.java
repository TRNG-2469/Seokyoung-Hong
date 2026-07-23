package com.revature.collections;

import java.util.Comparator;

//For practice, I will compare the Employees with the following criteria: alphabetical ASC, then by salary DESC, then lastly by id ASC
public class CustomSort implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) {
        if (e1 == null || e2 == null) {
            throw new NullPointerException();
        }

        if (e1.getName().compareTo(e2.getName()) != 0) {
            return e1.getName().compareTo(e2.getName());
        }

        if (Double.compare(e2.getSalary(), e1.getSalary()) != 0) {
            return Double.compare(e2.getSalary(), e1.getSalary());
        }

        return e1.getId() - e2.getId();
    }
}
