package dashboard;
import registration.Employee;



public class DashboardFactory {
    public static Dashboard getDashboard(Object obj) {
        if (obj.getClass() == Employee.class) {
            return new EmployeeDashboard();
        } 
        throw new IllegalArgumentException("Unknown dashboard type");
    }
}

