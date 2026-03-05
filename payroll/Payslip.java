/*
 * ------------------ Payslip Class ------------------
 *
 * Final class to prevent inheritance.
 * Implements Cloneable for shallow copy.
 * Demonstrates equals() & hashCode() contract.
 */
package payroll;

import registration.Employee;

import java.util.Objects;

public final class Payslip implements Cloneable {
    private Employee employee;
    private SalaryComponents salary;

    public Payslip(Employee employee, SalaryComponents salary) {
        this.employee = employee;
        this.salary = salary;
    }

    public Employee getEmployee() { return employee; }
    public SalaryComponents getSalary() { return salary; }

    @Override
    public String toString() {
        return "\n=== PAYSLIP ===\n" +
               employee.toString() +
               "\nGross Salary   : " + salary.calculateGross() +
               "\nNet Salary     : " + salary.calculateNet() +
               "\n====================\n";
    }

    // equals & hashCode contract
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payslip)) return false;
        Payslip payslip = (Payslip) o;
        return Objects.equals(employee, payslip.employee) &&
               Objects.equals(salary, payslip.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, salary);
    }

    // Shallow clone
    @Override
    public Payslip clone() {
        try {
            return (Payslip) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning failed", e);
        }
    }
}
