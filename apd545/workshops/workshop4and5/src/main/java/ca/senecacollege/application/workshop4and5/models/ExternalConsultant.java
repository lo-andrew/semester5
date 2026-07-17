package ca.senecacollege.application.workshop4and5.models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class ExternalConsultant extends Employee {
    private DoubleProperty hourlyRate;
    private StringProperty agencyName;

    public ExternalConsultant(StringProperty id, StringProperty name, StringProperty email,
                               ObservableList<String> skills, DoubleProperty hourlyRate,
                               StringProperty agencyName) {
        super(id, name, email, skills);
        this.hourlyRate = hourlyRate;
        this.agencyName = agencyName;
    }

    public double getHourlyRate() {
        return hourlyRate.get();
    }

    public DoubleProperty hourlyRateProperty() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate.set(hourlyRate);
    }

    public String getAgencyName() {
        return agencyName.get();
    }

    public StringProperty agencyNameProperty() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName.set(agencyName);
    }

    @Override
    public double getBaseCost() {
        return getHourlyRate();
    }
}
