package ca.senecacollege.application.models;

import java.time.LocalDate;

public class MaintenanceRecord {
    private Vehicle vehicle;
    private LocalDate date;
    private double cost;
    private String description;

    public MaintenanceRecord(Vehicle vehicle, LocalDate date, double cost, String description) {
        this.vehicle = vehicle;
        this.date = date;
        this.cost = cost;
        this.description = description;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
