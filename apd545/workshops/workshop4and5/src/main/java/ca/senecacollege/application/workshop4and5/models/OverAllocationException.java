package ca.senecacollege.application.workshop4and5.models;

/**
 * Thrown when assigning an employee to a project would push their total
 * allocated hours across all active projects above the 40-hour weekly limit.
 * Checked exception (extends Exception, not RuntimeException) so callers are
 * forced to handle the conflict rather than let it fail silently.
 */
public class OverAllocationException extends Exception {
    public OverAllocationException(String message) {
        super(message);
    }
}
