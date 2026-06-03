package ca.senecacollege.application.models;

import java.time.LocalDate;

public class MaintenanceRecord {
    private LocalDate date;
    private double cost;
    private String description;

    public MaintenanceRecord(LocalDate date, double cost, String description) {
        this.date = date;
        this.cost = cost;
        this.description = description;
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
