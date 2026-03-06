package dashboard;
import java.util.List;
import java.util.stream.Collectors;
import payroll.*;
import registration.*;
import java.util.List;

public class ManagerDashboard implements Dashboard {

    @Override
    public void displayRecentPayslips(List<Payslip> payslips) {
        System.out.println("=== Manager Dashboard: Team Payslips Overview ===");
        payslips.stream()
                .sorted(Comparator.comparing(Payslip::getDate).reversed())
                .limit(3)
                .forEach(System.out::println);
    }

    @Override
    public void displayYTDEarnings(Employee employee) {
        System.out.println("Manager View - YTD Earnings for " + employee.getName());
        double ytd = employee.getPayslips().stream()
                .mapToDouble(Payslip::getAmount)
                .sum();
        System.out.println("YTD Earnings: " + ytd);
    }

    @Override
    public void refreshData() {
        System.out.println("Refreshing Manager Dashboard data in real-time...");
    }
}

