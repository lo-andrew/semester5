package ca.senecacollege.application.workshop3.models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AmortizationEntry {
    private IntegerProperty month     = new SimpleIntegerProperty();
    private StringProperty  date      = new SimpleStringProperty();
    private DoubleProperty  payment   = new SimpleDoubleProperty();
    private DoubleProperty  principal = new SimpleDoubleProperty();
    private DoubleProperty  interest  = new SimpleDoubleProperty();
    private DoubleProperty  balance   = new SimpleDoubleProperty();

    public int getMonth() { return month.get(); }
    public void setMonth(int month) { this.month.set(month); }
    public IntegerProperty monthProperty() { return month; }

    public String getDate() { return date.get(); }
    public void setDate(String date) { this.date.set(date); }
    public StringProperty dateProperty() { return date; }

    public double getPayment() { return payment.get(); }
    public void setPayment(double payment) { this.payment.set(payment); }
    public DoubleProperty paymentProperty() { return payment; }

    public double getPrincipal() { return principal.get(); }
    public void setPrincipal(double principal) { this.principal.set(principal); }
    public DoubleProperty principalProperty() { return principal; }

    public double getInterest() { return interest.get(); }
    public void setInterest(double interest) { this.interest.set(interest); }
    public DoubleProperty interestProperty() { return interest; }

    public double getBalance() { return balance.get(); }
    public void setBalance(double balance) { this.balance.set(balance); }
    public DoubleProperty balanceProperty() { return balance; }
}
