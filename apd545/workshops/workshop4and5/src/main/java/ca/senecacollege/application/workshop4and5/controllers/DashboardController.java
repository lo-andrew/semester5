package ca.senecacollege.application.workshop4and5.controllers;

import ca.senecacollege.application.workshop4and5.MainApp;
import ca.senecacollege.application.workshop4and5.models.Assignment;
import ca.senecacollege.application.workshop4and5.models.Project;
import ca.senecacollege.application.workshop4and5.services.ResourceService;
import com.google.inject.Inject;
import com.google.inject.Injector;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;
import java.io.UncheckedIOException;

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

    private final ResourceService resourceService;
    private final Injector injector;

    private FilteredList<Project> filteredProjects;

    /** Rebuilt each time the selected project changes; drives totalCostLabel. */
    private DoubleBinding totalCostBinding;

    @Inject
    public DashboardController(ResourceService resourceService, Injector injector) {
        this.resourceService = resourceService;
        this.injector = injector;
    }

    @FXML
    private void initialize() {
        employeeNameColumn.setCellValueFactory(cellData ->
                cellData.getValue().getEmployee().nameProperty());
        roleColumn.setCellValueFactory(cellData ->
                cellData.getValue().roleProperty());
        allocatedHoursColumn.setCellValueFactory(cellData ->
                cellData.getValue().allocatedHoursProperty());
        allocatedHoursColumn.setCellFactory(
                TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        allocatedHoursColumn.setOnEditCommit(event ->
                event.getRowValue().setAllocatedHours(event.getNewValue().doubleValue()));

        costColumn.setCellValueFactory(cellData ->
                cellData.getValue().getCost());

        // formatting tablecell to render as currency
        costColumn.setCellFactory(col -> new TableCell<>() {
            @Override
            protected void updateItem(Number cost, boolean empty) {
                super.updateItem(cost, empty);
                setText(empty || cost == null ? null : String.format("$%,.2f", cost.doubleValue()));
            }
        });

        statusFilterChoiceBox.getItems().addAll("All", "Active", "Closed");
        statusFilterChoiceBox.setValue("All");

        filteredProjects = new FilteredList<>(resourceService.getAllProjects(), p -> true);
        projectListView.setItems(filteredProjects);

        // getting proj titles for list view
        projectListView.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(Project project, boolean empty) {
                super.updateItem(project, empty);
                setText(empty || project == null ? null : project.getTitle());
            }
        });

        // re-run handleFilter when input changes
        searchField.textProperty().addListener((obs, oldVal, newVal) -> handleFilter());
        statusFilterChoiceBox.valueProperty().addListener((obs, oldVal, newVal) -> handleFilter());

        projectListView.getSelectionModel().selectedItemProperty()
                .addListener((obs, oldProject, newProject) -> showProjectDetails(newProject));


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

    private void showProjectDetails(Project project) {
        totalCostLabel.textProperty().unbind();

        if (project == null) {
            projectTitleLabel.setText("");
            projectTypeLabel.setText("");
            assignmentsTable.setItems(FXCollections.observableArrayList());
            totalCostLabel.setText("Total Cost: $0.00");
            return;
        }

        projectTitleLabel.setText(project.getTitle());
        projectTypeLabel.setText(project.getClass().getSimpleName());
        assignmentsTable.setItems(project.getAssignments());

        totalCostBinding = Bindings.createDoubleBinding(
                () -> project.getAssignments().stream()
                        .mapToDouble(a -> a.getCost().get())
                        .sum(),
                project.getAssignments());
        totalCostLabel.textProperty().bind(Bindings.format("Total Cost: $%,.2f", totalCostBinding));
    }

    @FXML
    private void handleAddTeamMember() {
        Project selected = projectListView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            return; // no project to staff.
        }

        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("resource-allocator.fxml"));
            loader.setControllerFactory(injector::getInstance);
            Scene scene = new Scene(loader.load());

            AllocatorController allocatorController = loader.getController();
            allocatorController.setProject(selected);

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Resource Allocator - " + selected.getTitle());
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(addTeamMemberBtn.getScene().getWindow());
            dialogStage.setScene(scene);
            dialogStage.showAndWait();
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to load Resource Allocator", e);
        }
    }
}
