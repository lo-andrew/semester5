package ca.senecacollege.application.workshop4and5.controllers;

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
 * <p>
 * NOTE: TableView/TableColumn/ListView are left untyped for now since the
 * Project/Employee/Assignment domain models don't exist yet (Step 1 of the
 * backend, done as DIY). Once those models exist, parameterize these fields
 * (e.g. TableView&lt;Assignment&gt;, ListView&lt;Project&gt;) and wire:
 *   - FilteredList for the search/status filters
 *   - totalCostLabel bound to the sum of Assignment costs
 */
public class DashboardController {

    @FXML
    private TextField searchField;

    @FXML
    private ChoiceBox<String> statusFilterChoiceBox;

    @FXML
    private ListView<String> projectListView;

    @FXML
    private Label projectTitleLabel;

    @FXML
    private Label projectTypeLabel;

    @FXML
    private Label totalCostLabel;

    @FXML
    private TableView<Object> assignmentsTable;

    @FXML
    private TableColumn<Object, String> employeeNameColumn;

    @FXML
    private TableColumn<Object, String> roleColumn;

    @FXML
    private TableColumn<Object, Number> allocatedHoursColumn;

    @FXML
    private TableColumn<Object, Number> costColumn;

    @FXML
    private Button addTeamMemberBtn;

    @FXML
    private void initialize() {
        statusFilterChoiceBox.getItems().addAll("All", "Active", "Closed");
        statusFilterChoiceBox.setValue("All");
        // TODO (backend step): populate projectListView from ProjectRepository.findAll(),
        // hook up FilteredList for search/status, and bind totalCostLabel reactively.
    }

    @FXML
    private void handleAddTeamMember() {
        // TODO (backend step): open the Resource Allocator screen for the selected project.
    }
}
