/*
 * ------------------ FileService Class ------------------
 *
 * Handles file I/O operations for payslip download.
 * Generates unique filenames.
 */
package payroll;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class FileService {

    public DownloadToken savePayslip(Payslip payslip, String format) throws IOException {
        String filename = "payslip_" + System.currentTimeMillis() + "." + format.toLowerCase();

        try (FileWriter fw = new FileWriter(filename)) {
            fw.write(payslip.toString());
        }

        // Token expires in 2 minutes
        return new DownloadToken(filename, LocalDateTime.now().plusMinutes(2));
    }
}
