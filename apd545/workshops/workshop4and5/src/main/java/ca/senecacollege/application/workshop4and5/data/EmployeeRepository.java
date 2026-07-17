package ca.senecacollege.application.workshop4and5.data;

import ca.senecacollege.application.workshop4and5.models.Employee;
import ca.senecacollege.application.workshop4and5.models.ExternalConsultant;
import ca.senecacollege.application.workshop4and5.models.InternalStaff;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class EmployeeRepository {
    private static EmployeeRepository instance;

    private final ObservableList<Employee> allEmployees = FXCollections.observableArrayList();

    private EmployeeRepository(){
        seedData();
    }

    public static EmployeeRepository getInstance() {
        if (instance == null) {
            instance = new EmployeeRepository();
        }
        return instance;
    }

    public ObservableList<Employee> findAll(){
        return allEmployees;
    }

    public FilteredList<Employee> filterBySkill(String skill) {
        if (skill == null || skill.isBlank() || skill.equalsIgnoreCase("All Skills")) {
            return new FilteredList<>(allEmployees, e -> true);
        }
        return new FilteredList<>(allEmployees, employee -> employee.getSkills().contains(skill));
    }

    private void seedData() {
        allEmployees.add(new InternalStaff(
                new SimpleStringProperty("1"), new SimpleStringProperty("John Smith"),
                FXCollections.observableArrayList("Java", "JavaFX", "SQL"),
                new SimpleDoubleProperty(95000)));

        allEmployees.add(new InternalStaff(
                new SimpleStringProperty("2"), new SimpleStringProperty("Bob Johnson"),
                FXCollections.observableArrayList("Python", "Data Analysis"),
                new SimpleDoubleProperty(85000)));

        allEmployees.add(new ExternalConsultant(
                new SimpleStringProperty("3"), new SimpleStringProperty("Alice Lee"),
                FXCollections.observableArrayList("UI/UX Design", "Figma"),
                new SimpleDoubleProperty(75), new SimpleStringProperty("Design Partners Inc.")));

        allEmployees.add(new InternalStaff(
                new SimpleStringProperty("4"), new SimpleStringProperty("David Anderson"),
                FXCollections.observableArrayList("Project Management", "Agile"),
                new SimpleDoubleProperty(105000)));

        allEmployees.add(new ExternalConsultant(
                new SimpleStringProperty("5"), new SimpleStringProperty("Ann Grace"),
                FXCollections.observableArrayList("Cloud Architecture", "AWS", "DevOps"),
                new SimpleDoubleProperty(110), new SimpleStringProperty("CloudWorks Consulting")));
    }
}
