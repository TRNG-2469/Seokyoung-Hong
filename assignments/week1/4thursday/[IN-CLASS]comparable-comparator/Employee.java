package com.revature.collections;

public class Employee implements Comparable<Employee> {

    private int id;
    private String name;
    private double salary;

    public Employee() {

    }

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    //For practice, I will compare the Employees with the following criteria: alphabetical ASC, then by salary DESC, then lastly by id ASC
    public int compareTo(Employee other) {
        if (other == null) {
            throw new NullPointerException();
        }

        if (this.name.compareTo(other.name) != 0) {
            return this.name.compareTo(other.name);
        }

        if (Double.compare(other.salary, this.salary) != 0) {
            return Double.compare(other.salary, this.salary);
        }

        return this.id - other.id;
    }


}
