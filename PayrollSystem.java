import java.util.Scanner;

class Employee {
    int employeeId;
    String employeeName;
    String designation;
    double weeklyearnings;
    double weeklysalary;

    // Method to calculate bonus - should be overridden in child classes
    protected double calculateBonus() {
        return 0.0;
    }

    // Display method to print employee information, weekly salary, and annual earnings
    void display() {
        System.out.println("Employee ID: " + employeeId + "\nEmployee name: " + employeeName +
                "\nDesignation: " + designation + "\nWeekly Salary: " + weeklysalary + "\nAnnual Earnings: " + AnnualEarnings());
    }

    // Method for calculating Annual earnings Assuming 52 weeks in a year
    protected double AnnualEarnings() {
        return weeklyearnings * 52;
    }
}

class HourlyEmployee extends Employee {
    double hourlyRate;
    int hoursWorked;

    // Parameterized constructor
    HourlyEmployee(double hourlyRate, int hoursWorked) {
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        weeklyearnings = hourlyRate * hoursWorked;
    }
}

class SalariedEmployee extends Employee {
    double monthlySalary;

    // Parameterized constructor
    SalariedEmployee(double monthlySalary) {
        this.monthlySalary = monthlySalary;
        weeklysalary = monthlySalary / 4;
    }

    // Display method to print monthly salary
    void display() {
        super.display();
        System.out.println("Monthly salary: " + monthlySalary);
    }

    // Method for calculating Annual earnings - 12 months in a year
    protected double AnnualEarnings() {
        return monthlySalary * 12;
    }
}

class ExecutiveEmployee extends SalariedEmployee {
    double bonusPercentage;

    ExecutiveEmployee(int employeeId, String employeeName, String designation, double bonusPercentage, double monthlySalary) {
        super(monthlySalary);
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
        this.bonusPercentage = bonusPercentage;
        this.weeklyearnings = (monthlySalary + calculateBonus()) / 4;
    }

    // Override calculateBonus() method to provide specific bonus calculation
    protected double calculateBonus() {
        double baseBonus = super.calculateBonus();
        double executiveBonus = monthlySalary * (bonusPercentage / 100);
        weeklyearnings += executiveBonus;
        return baseBonus + executiveBonus;
    }

    // Override AnnualEarnings() method to include bonus calculation
    protected double AnnualEarnings() {
        return super.AnnualEarnings() + calculateBonus() * 12;
    }

    // Display function that prints employee info by invoking super to call its parent class
    void display() {
        super.display();
        System.out.println("Bonus Percentage: " + bonusPercentage);
        System.out.println("Weekly Earnings: " + weeklyearnings);
    }
}

public class EmpPayroll {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter employeeid: ");
        int employeeId = input.nextInt();
        input.nextLine();
        System.out.println("Enter name:");
        String employeeName = input.nextLine();
        System.out.println("Enter designation:");
        String designation = input.nextLine();
        System.out.println("Enter monthly salary:");
        double monthlySalary = input.nextDouble();

        ExecutiveEmployee ex = new ExecutiveEmployee(employeeId, employeeName, designation, 15.0, monthlySalary);
        ex.display();

        // Closing the Scanner object to prevent input leak
        input.close();
    }
}
