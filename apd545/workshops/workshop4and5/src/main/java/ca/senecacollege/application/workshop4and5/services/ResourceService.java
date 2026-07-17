package ca.senecacollege.application.workshop4and5.services;

import ca.senecacollege.application.workshop4and5.data.EmployeeRepository;
import ca.senecacollege.application.workshop4and5.data.ProjectRepository;
import ca.senecacollege.application.workshop4and5.models.Assignment;
import ca.senecacollege.application.workshop4and5.models.Employee;
import ca.senecacollege.application.workshop4and5.models.OverAllocationException;
import ca.senecacollege.application.workshop4and5.models.Project;
import com.google.inject.Inject;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.stream.Collectors;

public class ResourceService {
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    @Inject
    public ResourceService(EmployeeRepository employeeRepository, ProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    public ObservableList<Assignment> getAssignmentsByEmployee(Employee e) {
        ObservableList<Assignment> result = FXCollections.observableArrayList();
        for (Project project : projectRepository.findAll()) {
            for (Assignment assignment : project.getAssignments()) {
                if (assignment.getEmployee() == e) {
                    result.add(assignment);
                }
            }
        }
        return result;
    }

    public void assignTeamMember(Project p, Employee e, String role, double hours) throws OverAllocationException {
        double existingHours = 0.0;
        for (Assignment assignment : getAssignmentsByEmployee(e)) {
            existingHours += assignment.getAllocatedHours();
        }

        double totalLoad = existingHours + hours;
        if (totalLoad > 40) {
            throw new OverAllocationException(
                    e.getName() + " would be allocated " + totalLoad + " hours, exceeding the 40-hour weekly limit.");
        }

        Assignment assignment = new Assignment(new SimpleStringProperty(role), new SimpleDoubleProperty(hours), e);
        p.getAssignments().add(assignment);
    }
}
