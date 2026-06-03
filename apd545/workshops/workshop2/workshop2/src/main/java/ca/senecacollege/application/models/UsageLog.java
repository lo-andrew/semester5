package ca.senecacollege.application.models;

import java.time.LocalDate;

public class UsageLog {
    private LocalDate startDate;
    private LocalDate endDate;
    private double distance;

    public UsageLog(LocalDate startDate, LocalDate endDate, double distance) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.distance = distance;
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
