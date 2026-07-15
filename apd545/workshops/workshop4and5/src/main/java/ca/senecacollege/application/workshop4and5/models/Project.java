package ca.senecacollege.application.workshop4and5.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public abstract class Project {
    private StringProperty id;
    private StringProperty title;
    private ObjectProperty<Status> status;
    private ObservableList<Assignment> assignments;

    public Project(StringProperty id, StringProperty title, ObjectProperty<Status> status, ObservableList<Assignment> assignments) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.assignments = assignments;
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public Status getStatus() {
        return status.get();
    }

    public ObjectProperty<Status> statusProperty() {
        return status;
    }

    public void setStatus(Status status) {
        this.status.set(status);
    }

    public ObservableList<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(ObservableList<Assignment> assignments) {
        this.assignments = assignments;
    }

    public abstract double getProfitMargin();
}
