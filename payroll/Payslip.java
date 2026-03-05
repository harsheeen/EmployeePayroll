package payroll;

/*
 * ------------------ Payslip Class ------------------
 *
 * Represents a payslip for an employee.
 * Demonstrates composition (Employee + SalaryComponents).
 */


import registration.Employee;

public class Payslip {
    private Employee employee;
    private SalaryComponents salary;

    public Payslip(Employee employee, SalaryComponents salary) {
        this.employee = employee;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\n=== PAYSLIP ===\n" +
               employee.toString() +
               "\nBasic Salary : " + salary.getBasicSalary() +
               "\nAllowances   : " + salary.getAllowances() +
               "\nDeductions   : " + salary.getDeductions() +
               "\nNet Salary   : " + salary.calculateNetSalary() +
               "\n====================\n";
    }
}

