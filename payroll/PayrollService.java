package payroll;

/*
 * ------------------ PayrollService Class ------------------
 *
 * Handles salary updates and payslip generation.
 */

import registration.Employee;

public class PayrollService {

    public Payslip generatePayslip(Employee emp, SalaryComponents salary) {
        return new Payslip(emp, salary);
    }

    public SalaryComponents createSalaryStructure(double basic, double allowances, double pf, double tax, double deductions) {
        return new SalaryComponents()
                .setBasicSalary(basic)
                .setAllowances(allowances)
                .setPf(pf)
                .setTax(tax)
                .setDeductions(deductions);
    }
}
