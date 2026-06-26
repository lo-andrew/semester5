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

import ca.senecacollege.application.workshop3.enums.PaymentFrequency;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Loan {

    private DoubleProperty downPayment = new SimpleDoubleProperty();
    private DoubleProperty interestRate = new SimpleDoubleProperty();
    private IntegerProperty duration = new SimpleIntegerProperty();
    private ObjectProperty<PaymentFrequency> frequency = new SimpleObjectProperty<>();
    private ObjectProperty<Customer> customer = new SimpleObjectProperty<>();
    private ObjectProperty<Vehicle> vehicle = new SimpleObjectProperty<>();

    public double getDownPayment() {
        return downPayment.get();
    }

    public DoubleProperty downPaymentProperty() {
        return downPayment;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment.set(downPayment);
    }

    public double getInterestRate() {
        return interestRate.get();
    }

    public DoubleProperty interestRateProperty() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate.set(interestRate);
    }

    public int getDuration() {
        return duration.get();
    }

    public IntegerProperty durationProperty() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration.set(duration);
    }

    public PaymentFrequency getFrequency() {
        return frequency.get();
    }

    public ObjectProperty<PaymentFrequency> frequencyProperty() {
        return frequency;
    }

    public void setFrequency(PaymentFrequency frequency) {
        this.frequency.set(frequency);
    }

    public Customer getCustomer() {
        return customer.get();
    }

    public ObjectProperty<Customer> customerProperty() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer.set(customer);
    }

    public Vehicle getVehicle() {
        return vehicle.get();
    }

    public ObjectProperty<Vehicle> vehicleProperty() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle.set(vehicle);
    }
}
