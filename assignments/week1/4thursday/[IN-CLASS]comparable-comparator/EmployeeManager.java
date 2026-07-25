package com.revature.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeManager {
    public static void main(String[] args) {

        Employee e1 = new Employee(1, "Jon", 10000);
        Employee e2 = new Employee(2, "Abc", 20000);
        Employee e3 = new Employee(3, "Betty", 30000);
        Employee e4 = new Employee(4, "Betty", 300000);
        Employee e5 = new Employee(5, "Jon", 1);

        List<Employee> list1 = new ArrayList<>();
        List<Employee> list2 = new ArrayList<>();
        list1.add(e1);
        list1.add(e2);
        list1.add(e3);
        list1.add(e4);
        list1.add(e5);
        list2.add(e5);
        list2.add(e4);
        list2.add(e3);
        list2.add(e2);
        list2.add(e1);

        System.out.println("Before sorting: list1:");
        for (Employee e : list1) {
            System.out.println(e);
        }
        System.out.println("Before sorting, list2:");
        for (Employee e : list2) {
            System.out.println(e);
        }

        System.out.println("Sorted list1 with Comparable");
        Collections.sort(list1);
        for (Employee e : list1) {
            System.out.println(e);
        }

        System.out.println("Sorted list2 with Comparator");
        CustomSort employeeComparator = new CustomSort();
        Collections.sort(list2, employeeComparator);
        for (Employee e : list2) {
            System.out.println(e);
        }


    }
}
