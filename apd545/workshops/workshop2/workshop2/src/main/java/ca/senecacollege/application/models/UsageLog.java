package ca.senecacollege.application.models;

import java.time.LocalDate;

public class UsageLog {
    private Vehicle vehicle;
    private LocalDate startDate;
    private LocalDate endDate;
    private double distance;

    public UsageLog(Vehicle vehicle, LocalDate startDate, LocalDate endDate, double distance) {
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.distance = distance;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
