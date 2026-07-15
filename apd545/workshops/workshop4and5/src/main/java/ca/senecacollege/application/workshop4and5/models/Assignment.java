package ca.senecacollege.application.workshop4and5.models;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;

public class Assignment {
    private StringProperty role;
    private DoubleProperty allocatedHours;
    private Employee employee;

    public Assignment(StringProperty role, DoubleProperty allocatedHours, Employee employee) {
        this.role = role;
        this.allocatedHours = allocatedHours;
        this.employee = employee;
    }

    public String getRole() {
        return role.get();
    }

    public StringProperty roleProperty() {
        return role;
    }

    public void setRole(String role) {
        this.role.set(role);
    }

    public double getAllocatedHours() {
        return allocatedHours.get();
    }

    public DoubleProperty allocatedHoursProperty() {
        return allocatedHours;
    }

    public void setAllocatedHours(double allocatedHours) {
        this.allocatedHours.set(allocatedHours);
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Cost is derived, not stored: hours * the assigned employee's base cost.
     * Recomputes automatically whenever allocatedHours changes.
     */
    public DoubleBinding getCost() {
        return Bindings.createDoubleBinding(
                () -> allocatedHours.get() * employee.getBaseCost(),
                allocatedHours
        );
    }
}
