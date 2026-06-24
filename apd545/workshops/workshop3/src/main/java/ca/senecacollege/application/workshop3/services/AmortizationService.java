package ca.senecacollege.application.workshop3.services;

import ca.senecacollege.application.workshop3.models.AmortizationEntry;
import ca.senecacollege.application.workshop3.models.Loan;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AmortizationService {

    public List<AmortizationEntry> generateSchedule(Loan loan) {
        double principal    = loan.getVehicle().getPrice() - loan.getDownPayment();
        double annualRate   = loan.getInterestRate() / 100.0;
        int    durationMonths = loan.getDuration();

        int paymentsPerYear = switch (loan.getFrequency()) {
            case WEEKLY    -> 52;
            case BIWEEKLY  -> 26;
            case MONTHLY   -> 12;
        };

        double periodicRate  = annualRate / paymentsPerYear;
        int    totalPayments = (int) Math.round(durationMonths * paymentsPerYear / 12.0);

        double payment = (periodicRate == 0)
            ? principal / totalPayments
            : principal * periodicRate * Math.pow(1 + periodicRate, totalPayments)
              / (Math.pow(1 + periodicRate, totalPayments) - 1);

        List<AmortizationEntry> schedule = new ArrayList<>();
        double    balance = principal;
        LocalDate date    = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMM dd, yyyy");

        for (int i = 1; i <= totalPayments; i++) {
            date = switch (loan.getFrequency()) {
                case WEEKLY   -> date.plusWeeks(1);
                case BIWEEKLY -> date.plusWeeks(2);
                case MONTHLY  -> date.plusMonths(1);
            };

            double interestPortion   = balance * periodicRate;
            double principalPortion  = payment - interestPortion;
            balance -= principalPortion;
            if (balance < 0) balance = 0;

            AmortizationEntry entry = new AmortizationEntry();
            entry.setMonth(i);
            entry.setDate(date.format(fmt));
            entry.setPayment(payment);
            entry.setPrincipal(principalPortion);
            entry.setInterest(interestPortion);
            entry.setBalance(balance);
            schedule.add(entry);
        }

        return schedule;
    }
}
