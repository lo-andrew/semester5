package ca.senecacollege.application.workshop4and5.models;

import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public abstract class Employee {
    private StringProperty id;
    private StringProperty name;
    private StringProperty email;
    private ObservableList<String> skills;

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
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

    public Employee(StringProperty id, StringProperty name, StringProperty email, ObservableList<String> skills) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.skills = skills;
    }

    public abstract double getBaseCost();
}
