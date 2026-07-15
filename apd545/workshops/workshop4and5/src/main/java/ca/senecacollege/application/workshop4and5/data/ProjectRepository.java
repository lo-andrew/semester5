package ca.senecacollege.application.workshop4and5.data;

import ca.senecacollege.application.workshop4and5.models.FixedPriceProject;
import ca.senecacollege.application.workshop4and5.models.Project;
import ca.senecacollege.application.workshop4and5.models.Status;
import ca.senecacollege.application.workshop4and5.models.TimeMaterialProject;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import static ca.senecacollege.application.workshop4and5.models.Status.ACTIVE;
import static ca.senecacollege.application.workshop4and5.models.Status.CLOSED;
import static ca.senecacollege.application.workshop4and5.models.Status.PLANNING;

public class ProjectRepository {

    private final ObservableList<Project> allProjects;

    public ProjectRepository() {
        allProjects = FXCollections.observableArrayList();

        // --- Fixed-price projects ---
        allProjects.add(fixedPriceProject("1", "AI Upgrade", ACTIVE, 50000.0, 0.20));
        allProjects.add(fixedPriceProject("2", "Web Revamp", ACTIVE, 30000.0, 0.15));
        allProjects.add(fixedPriceProject("3", "Mobile Banking App", PLANNING, 120000.0, 0.25));
        allProjects.add(fixedPriceProject("4", "Inventory System", CLOSED, 45000.0, 0.10));
        allProjects.add(fixedPriceProject("5", "HR Portal", ACTIVE, 60000.0, 0.18));

        // --- Time & materials projects ---
        allProjects.add(timeMaterialProject("6", "Cloud Migration", ACTIVE, 175.0));
        allProjects.add(timeMaterialProject("7", "Data Warehouse", PLANNING, 150.0));
        allProjects.add(timeMaterialProject("8", "Security Audit", ACTIVE, 200.0));
        allProjects.add(timeMaterialProject("9", "Support Retainer", CLOSED, 125.0));
        allProjects.add(timeMaterialProject("10", "DevOps Tooling", ACTIVE, 160.0));
    }

    public ObservableList<Project> findAll() {
        return allProjects;
    }

    /**
     * Wraps the raw seed values in JavaFX properties before invoking the
     * FixedPriceProject constructor, which requires Property types rather
     * than plain primitives/Strings.
     */
    private FixedPriceProject fixedPriceProject(String id, String title, Status status,
                                                 double maxBudget, double clientMarkup) {
        return new FixedPriceProject(
                new SimpleStringProperty(id),
                new SimpleStringProperty(title),
                new SimpleObjectProperty<>(status),
                FXCollections.observableArrayList(),
                new SimpleDoubleProperty(maxBudget),
                new SimpleDoubleProperty(clientMarkup)
        );
    }

    private TimeMaterialProject timeMaterialProject(String id, String title, Status status,
                                                      double hourlyCap) {
        return new TimeMaterialProject(
                new SimpleStringProperty(id),
                new SimpleStringProperty(title),
                new SimpleObjectProperty<>(status),
                FXCollections.observableArrayList(),
                new SimpleDoubleProperty(hourlyCap)
        );
    }
}
