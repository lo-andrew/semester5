package ca.senecacollege.application.workshop4and5.controllers;

import ca.senecacollege.application.workshop4and5.data.ProjectRepository;
import ca.senecacollege.application.workshop4and5.models.Assignment;
import ca.senecacollege.application.workshop4and5.models.Project;
import ca.senecacollege.application.workshop4and5.services.ResourceService;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * Controller for the Portfolio Dashboard (portfolio-dashboard.fxml).
 * Screen 2: Master-detail overview of all projects and their costs.
 */
public class DashboardController {

    @FXML
    private TextField searchField;

    @FXML
    private ChoiceBox<String> statusFilterChoiceBox;

    @FXML
    private ListView<Project> projectListView;

    @FXML
    private Label projectTitleLabel;

    @FXML
    private Label projectTypeLabel;

    @FXML
    private Label totalCostLabel;

    @FXML
    private TableView<Assignment> assignmentsTable;

    @FXML
    private TableColumn<Assignment, String> employeeNameColumn;

    @FXML
    private TableColumn<Assignment, String> roleColumn;

    @FXML
    private TableColumn<Assignment, Number> allocatedHoursColumn;

    @FXML
    private TableColumn<Assignment, Number> costColumn;

    @FXML
    private Button addTeamMemberBtn;

    ProjectRepository projRepo;
    ResourceService resourceService;

    private FilteredList<Project> filteredProjects;

    @FXML
    private void initialize() {
        statusFilterChoiceBox.getItems().addAll("All", "Active", "Closed");
        statusFilterChoiceBox.setValue("All");

        filteredProjects = new FilteredList<>(projRepo.findAll(), p -> true);
        projectListView.setItems(filteredProjects);

        // Live filtering: re-run handleFilter() whenever either input changes,
        // rather than waiting on a button click / Enter key.
        searchField.textProperty().addListener((obs, oldVal, newVal) -> handleFilter());
        statusFilterChoiceBox.valueProperty().addListener((obs, oldVal, newVal) -> handleFilter());

        // TODO (next): bind totalCostLabel to the sum of the selected project's
        // Assignment costs, and populate projectTitleLabel/projectTypeLabel/
        // assignmentsTable when a project is selected in projectListView.
    }

    @FXML
    private void handleFilter() {
        String query = searchField.getText() == null ? "" : searchField.getText().trim().toLowerCase();
        String status = statusFilterChoiceBox.getValue();

        filteredProjects.setPredicate(project -> {
            boolean matchesTitle = project.getTitle().toLowerCase().contains(query);
            boolean matchesStatus = "All".equals(status) || project.getStatus().name().equalsIgnoreCase(status);
            return matchesTitle && matchesStatus;
        });
    }
}
