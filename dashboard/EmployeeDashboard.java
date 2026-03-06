package dashboard;
import java.util.List;
import java.util.stream.Collectors;
import payroll.*;
import registration.*;


public class EmployeeDashboard implements Dashboard {

    @Override
    public void displayRecentPayslips(List<Payslip> payslips) {
        System.out.println("=== Employee Dashboard: Recent Payslips ===");
        payslips.stream()
                .sorted(Comparator.comparing(Payslip::getDate).reversed())
                .limit(3)
                .forEach(System.out::println);
    }

    @Override
    public void displayYTDEarnings(Employee employee) {
        double ytd = employee.getPayslips().stream()
                .mapToDouble(Payslip::getAmount)
                .sum();
        System.out.println("YTD Earnings: " + ytd);
    }

    @Override
    public void refreshData() {
        System.out.println("Refreshing Employee Dashboard data in real-time...");
    }
}
