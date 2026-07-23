package week1.thursday;

//Step1: Legacy code pasted, will be refactored
public class EmployeeProfile {

    //Step2: Implement Data Protection Barriers
    private String employeeId;
    private String name;
    private double monthlySalary;

    public EmployeeProfile(String employeeId, String name, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.monthlySalary = salary;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.equals("")) {
            System.out.println("Not an eligible name");
            return;
        }

        this.name = name;
    }

    public double getMonthlySalary() {
        return this.monthlySalary;
    }

    public void setMonthlySalary(double salary) {
        if (salary < 0.0) {
            System.out.println("Salary cannot be negative");
            return;
        }

        this.monthlySalary = salary;
    }
}