package week1.thursday;

public class HRApp {

    public static void main(String[] args) {

        //Step 3: Verify getters work, and bounbds
        EmployeeProfile ep = new EmployeeProfile("1", "Seokyoung Hong", 1000000000);

        System.out.println("Employee ID: " + ep.getEmployeeId());
        System.out.println("Employee Name: " + ep.getName());
        System.out.println("Employee Monthly Salary " + ep.getMonthlySalary());

        //Verify these are blocked
        ep.setMonthlySalary(-5000.00);
        ep.setName(null);

        System.out.println("Employee information should be unchanged:");
        System.out.println("Employee Name: " + ep.getName());
        System.out.println("Employee Monthly Salary " + ep.getMonthlySalary());
    }
}
