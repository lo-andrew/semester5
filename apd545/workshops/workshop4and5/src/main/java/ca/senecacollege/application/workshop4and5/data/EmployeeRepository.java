package ca.senecacollege.application.workshop4and5.data;

import ca.senecacollege.application.workshop4and5.models.Employee;
import ca.senecacollege.application.workshop4and5.models.Project;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class EmployeeRepository {
    private ObservableList<Employee> allEmployees;

    public ObservableList<Employee> findAll(){
        return allEmployees;
    }

    public FilteredList<Employee> filterBySkill(String skill) {
        if (skill == null || skill.isBlank() || skill.equalsIgnoreCase("All Skills")) {
            return new FilteredList<>(allEmployees, e -> true);
        }
        return new FilteredList<>(allEmployees, employee -> employee.getSkills().contains(skill));
    }
}
