package ca.senecacollege.application.workshop3.models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;

public class AmortizationEntry {
    private IntegerProperty month;
    private DoubleProperty principal;
    private DoubleProperty interest;
    private DoubleProperty balance;

    public int getMonth() {
        return month.get();
    }

    public IntegerProperty monthProperty() {
        return month;
    }

    public void setMonth(int month) {
        this.month.set(month);
    }

    public double getPrincipal() {
        return principal.get();
    }

    public DoubleProperty principalProperty() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal.set(principal);
    }

    public double getInterest() {
        return interest.get();
    }

    public DoubleProperty interestProperty() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest.set(interest);
    }

    public double getBalance() {
        return balance.get();
    }

    public DoubleProperty balanceProperty() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance.set(balance);
    }
}
