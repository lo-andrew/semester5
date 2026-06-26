/**********************************************
 Workshop # 3
 Course:APD545 - Semester 5
 Last Name: Lo
 First Name: Andrew
 ID: 162539217
 Section: NBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: June 26th, 2026
 **********************************************/
package ca.senecacollege.application.workshop3.models;

import ca.senecacollege.application.workshop3.interfaces.LoanCalculation;

public class FixedRateLoan implements LoanCalculation{

    @Override
    public double calculatePayment(Loan loan) {
        double principal = loan.getVehicle().getPrice() - loan.getDownPayment();
        double annualRate = loan.getInterestRate() / 100.0;

        int paymentsPerYear = switch (loan.getFrequency()) {
            case WEEKLY -> 52;
            case BIWEEKLY -> 26;
            case MONTHLY -> 12;
        };

        double periodicRate  = annualRate / paymentsPerYear;
        int    totalPayments = (int) Math.round(loan.getDuration() * paymentsPerYear / 12.0);

        if (periodicRate == 0) return principal / totalPayments;

        return principal * periodicRate * Math.pow(1 + periodicRate, totalPayments)
               / (Math.pow(1 + periodicRate, totalPayments) - 1);
    }
}
