

import registration.*;
import authentication.*;
import payroll.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Employee emp = null;

        // ============================
        // UC1: Employee Registration
        // ============================
        System.out.println("=== USE CASE 1: EMPLOYEE REGISTRATION ===");

        try {
            System.out.print("Enter Employee ID (EMP-XXXX): ");
            String empId = sc.nextLine();
            Validator.validateEmpId(empId);

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            Validator.validateEmail(email);

            System.out.print("Enter Phone Number: ");
            String phone = sc.nextLine();
            Validator.validatePhone(phone);

            System.out.print("Create Username: ");
            String username = sc.nextLine();

            System.out.print("Create Password: ");
            String password = sc.nextLine();

            UserAccount ua = new UserAccount(username, password);
            emp = new Employee(empId, name, email, phone, ua);

            emp.persist(); // save to file

            System.out.println("\nEmployee Registered Successfully!\n");
            System.out.println(emp);

        } catch (ValidationException e) {
            System.out.println("\nValidation Failed: " + e.getMessage());
            return;
        } catch (IOException e) {
            System.out.println("\nError saving employee data!");
            return;
        }

        // ============================
        // UC2: Authentication & Login
        // ============================
        System.out.println("\n=== USE CASE 2: EMPLOYEE AUTHENTICATION & LOGIN ===");

        AuthenticationService auth = new AuthenticationService();
        Session session = auth.login();

        if (session == null || session.isExpired()) {
            System.out.println("Login failed or session expired.");
            return;
        }

        System.out.println("\n" + session);

        // ============================
        // UC3: Salary Management
        // ============================
        System.out.println("\n=== USE CASE 3: SALARY MANAGEMENT ===");

        System.out.print("Enter Basic Salary: ");
        double basic = sc.nextDouble();

        System.out.print("Enter Allowances: ");
        double allowances = sc.nextDouble();

        System.out.print("Enter PF Contribution: ");
        double pf = sc.nextDouble();

        System.out.print("Enter Tax: ");
        double tax = sc.nextDouble();

        System.out.print("Enter Other Deductions: ");
        double deductions = sc.nextDouble();

        PayrollService payrollService = new PayrollService();
        SalaryComponents salary = payrollService.createSalaryStructure(basic, allowances, pf, tax, deductions);

        Payslip payslip = payrollService.generatePayslip(emp, salary);
        System.out.println(payslip);

        // ============================
        // UC4: Payslip Print / Download
        // ============================
        System.out.println("\n=== USE CASE 4: PAYSLIP PRINT / DOWNLOAD ===");

        FileService fileService = new FileService();
        try {
            // Clone payslip to preserve original data integrity
            Payslip payslipCopy = payslip.clone();

            // Save as text format
            DownloadToken token = fileService.savePayslip(payslipCopy, "txt");

            System.out.println("Payslip saved as: " + token.getFilename());
            System.out.println("Download valid until: " + token.getExpiry());

            if (token.isExpired()) {
                System.out.println("Download expired. Please regenerate.");
            }
        } catch (IOException e) {
            System.out.println("Error saving payslip: " + e.getMessage());
        }
    }
}
