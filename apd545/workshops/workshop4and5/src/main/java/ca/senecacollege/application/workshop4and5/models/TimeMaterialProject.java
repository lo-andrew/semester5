package ca.senecacollege.application.workshop4and5.models;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class TimeMaterialProject extends Project {
    private DoubleProperty hourlyCap;
    private DoubleBinding burnRate;

    public double getHourlyCap() {
        return hourlyCap.get();
    }

    public DoubleProperty hourlyCapProperty() {
        return hourlyCap;
    }

    public void setHourlyCap(double hourlyCap) {
        this.hourlyCap.set(hourlyCap);
    }

    public double getBurnRate() {
        return burnRate.get();
    }

    public DoubleBinding burnRateProperty() {
        return burnRate;
    }

    public TimeMaterialProject(StringProperty id, StringProperty title, ObjectProperty<Status> status,
                                ObservableList<Assignment> assignments, DoubleProperty hourlyCap) {
        super(id, title, status, assignments);
        this.hourlyCap = hourlyCap;

        // Running total of cost incurred so far across all assignments. Recomputes
        // whenever assignments are added/removed. NOTE: to also react when an
        // existing assignment's hours are edited (not just added/removed), build
        // this project's `assignments` ObservableList with an extractor, e.g.:
        //   FXCollections.observableArrayList(a -> new Observable[]{ a.allocatedHoursProperty() })
        // when it's created in the repository/service layer.
        this.burnRate = Bindings.createDoubleBinding(() -> {
            double total = 0.0;
            for (Assignment assignment : getAssignments()) {
                total += assignment.getCost().get();
            }
            return total;
        }, getAssignments());
    }

    @Override
    public double getProfitMargin() {
        double totalCost = 0.0;
        for (Assignment assignment : getAssignments()) {
            totalCost += assignment.getCost().get();
        }
        double totalHours = 0.0;
        for (Assignment assignment : getAssignments()) {
            totalHours += assignment.getAllocatedHours();
        }
        double revenue = totalHours * getHourlyCap();
        if (revenue == 0) {
            return 0;
        }
        return (revenue - totalCost) / revenue;
    }
}
