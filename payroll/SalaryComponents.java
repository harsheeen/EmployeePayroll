/*
 * ------------------ SalaryComponents Class ------------------
 *
 * Encapsulates salary details for an employee.
 * Demonstrates encapsulation and calculation logic.
 */
package payroll;
/*
 * ------------------ SalaryComponents Class ------------------
 *
 * Encapsulates salary details for an employee.
 * Demonstrates encapsulation, fluent interface, and Stream API usage.
 */


import java.util.stream.Stream;

public class SalaryComponents {
    private double basicSalary;
    private double allowances;
    private double pf;   // Provident Fund
    private double tax;  // Income Tax
    private double deductions;

    // Fluent interface setters
    public SalaryComponents setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
        return this;
    }

    public SalaryComponents setAllowances(double allowances) {
        this.allowances = allowances;
        return this;
    }

    public SalaryComponents setPf(double pf) {
        this.pf = pf;
        return this;
    }

    public SalaryComponents setTax(double tax) {
        this.tax = tax;
        return this;
    }

    public SalaryComponents setDeductions(double deductions) {
        this.deductions = deductions;
        return this;
    }

    // Gross salary = basic + allowances
    public double calculateGross() {
        return basicSalary + allowances;
    }

    // Net salary = gross - (pf + tax + deductions)
    public double calculateNet() {
        return calculateGross() - Stream.of(pf, tax, deductions).mapToDouble(Double::doubleValue).sum();
    }
}
