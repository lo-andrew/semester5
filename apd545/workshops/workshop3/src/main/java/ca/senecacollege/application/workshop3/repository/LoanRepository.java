package ca.senecacollege.application.workshop3.repository;

import ca.senecacollege.application.workshop3.models.Loan;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class LoanRepository {
    private List<Loan> loans = new ArrayList<>();

    public void saveLoan(Loan loan){
        loans.add(loan);
    }

    public List<Loan> getAllLoans(){
        return loans;
    }
}
