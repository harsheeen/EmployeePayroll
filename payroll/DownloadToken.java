/*
 * ------------------ DownloadToken Class ------------------
 *
 * Immutable object representing a download authorization.
 * Includes expiry mechanism.
 */
package payroll;

import java.time.LocalDateTime;

public final class DownloadToken {
    private final String filename;
    private final LocalDateTime expiry;

    public DownloadToken(String filename, LocalDateTime expiry) {
        this.filename = filename;
        this.expiry = expiry;
    }

    public String getFilename() { return filename; }
    public LocalDateTime getExpiry() { return expiry; }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expiry);
    }
}
