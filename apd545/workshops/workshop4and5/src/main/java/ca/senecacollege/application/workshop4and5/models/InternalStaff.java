package ca.senecacollege.application.workshop4and5.models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class InternalStaff extends Employee {

    /** Standard full-time work hours used to convert an annual salary into an hourly base cost. */
    private static final double WORK_HOURS_PER_YEAR = 52 * 40;

    private DoubleProperty annualSalary;

    public InternalStaff(StringProperty id, StringProperty name, ObservableList<String> skills,
                          DoubleProperty annualSalary) {
        super(id, name, skills);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary.get();
    }

    public DoubleProperty annualSalaryProperty() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary.set(annualSalary);
    }

    @Override
    public double getBaseCost() {
        return getAnnualSalary() / WORK_HOURS_PER_YEAR;
    }
}
