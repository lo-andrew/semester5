package ca.senecacollege.application.workshop4and5.models;

import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public abstract class Employee {
    private StringProperty id;
    private StringProperty name;
    private ObservableList<String> skills;

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public ObservableList<String> getSkills() {
        return skills;
    }

    public void setSkills(ObservableList<String> skills) {
        this.skills = skills;
    }

    public Employee(StringProperty id, StringProperty name, ObservableList<String> skills) {
        this.id = id;
        this.name = name;
        this.skills = skills;
    }

    public abstract double getBaseCost();
}
