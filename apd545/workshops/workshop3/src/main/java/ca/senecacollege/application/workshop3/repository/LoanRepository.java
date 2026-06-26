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
