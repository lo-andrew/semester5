package ca.senecacollege.application.workshop3.interfaces;

import ca.senecacollege.application.workshop3.models.Loan;

public interface LoanCalculation {
    double calculatePayment(Loan loan);
}
