package ca.senecacollege.application.workshop4and5.models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class FixedPriceProject extends Project {
    private DoubleProperty maxBudget;
    private DoubleProperty clientMarkup;

    public FixedPriceProject(StringProperty id, StringProperty title, ObjectProperty<Status> status,
                              ObservableList<Assignment> assignments, DoubleProperty maxBudget,
                              DoubleProperty clientMarkup) {
        super(id, title, status, assignments);
        this.maxBudget = maxBudget;
        this.clientMarkup = clientMarkup;
    }

    public double getMaxBudget() {
        return maxBudget.get();
    }

    public DoubleProperty maxBudgetProperty() {
        return maxBudget;
    }

    public void setMaxBudget(double maxBudget) {
        this.maxBudget.set(maxBudget);
    }

    public double getClientMarkup() {
        return clientMarkup.get();
    }

    public DoubleProperty clientMarkupProperty() {
        return clientMarkup;
    }

    public void setClientMarkup(double clientMarkup) {
        this.clientMarkup.set(clientMarkup);
    }

    /**
     * Revenue billed to the client is the fixed budget plus the agreed markup.
     * Profit margin is how much of that billed revenue is left after paying
     * for the actual assignment costs.
     */
    @Override
    public double getProfitMargin() {
        double totalCost = 0.0;
        for (Assignment assignment : getAssignments()) {
            totalCost += assignment.getCost().get();
        }
        double revenue = getMaxBudget() * (1 + getClientMarkup());
        if (revenue == 0) {
            return 0;
        }
        return (revenue - totalCost) / revenue;
    }
}
