package dashboard;
import registration.*;
import payroll.*;
import java.util.*;
public interface Dashboard {
    void displayRecentPayslips(List<Payslip> payslips);
    void displayYTDEarnings(Employee employee);
    void refreshData();
}
