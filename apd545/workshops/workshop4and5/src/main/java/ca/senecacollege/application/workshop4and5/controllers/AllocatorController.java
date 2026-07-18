package ca.senecacollege.application.workshop4and5.controllers;

import ca.senecacollege.application.workshop4and5.models.Assignment;
import ca.senecacollege.application.workshop4and5.models.Employee;
import ca.senecacollege.application.workshop4and5.models.OverAllocationException;
import ca.senecacollege.application.workshop4and5.models.Project;
import ca.senecacollege.application.workshop4and5.services.ResourceService;
import com.google.inject.Inject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class AllocatorController {

    @FXML
    private ComboBox<String> skillFilterComboBox;

    @FXML
    private ComboBox<Employee> employeeComboBox;

    @FXML
    private TextField roleField;

    @FXML
    private TextField newHoursField;

    @FXML
    private Label projectedLoadLabel;

    @FXML
    private Button confirmBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private TableView<Assignment> currentWorkloadTable;

    @FXML
    private TableColumn<Assignment, String> workloadProjectColumn;

    @FXML
    private TableColumn<Assignment, String> workloadRoleColumn;

    @FXML
    private TableColumn<Assignment, Number> workloadHoursColumn;

    @FXML
    private TableColumn<Assignment, Number> workloadCostColumn;

    private final ResourceService resourceService;
    private Project project;

    public void setProject(Project project){
        this.project = project;
    }

    @Inject
    public AllocatorController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @FXML
    private void initialize() {
        projectedLoadLabel.setText("0 / 40 hrs");

        workloadProjectColumn.setCellValueFactory(cellData -> cellData.getValue().getProject().titleProperty());
        workloadRoleColumn.setCellValueFactory(cellData -> cellData.getValue().roleProperty());
        workloadHoursColumn.setCellValueFactory(cellData -> cellData.getValue().allocatedHoursProperty());
        workloadHoursColumn.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        workloadHoursColumn.setOnEditCommit(event -> {
            event.getRowValue().setAllocatedHours(event.getNewValue().doubleValue());
            // total needs to catch up here
            handleLiveBalancing();
        });
        workloadCostColumn.setCellValueFactory(cellData ->
                cellData.getValue().getCost());
        // need to get cost as currency
        workloadCostColumn.setCellFactory(col -> new TableCell<>() {
            @Override
            protected void updateItem(Number cost, boolean empty) {
                super.updateItem(cost, empty);
                setText(empty || cost == null ? null : String.format("$%,.2f", cost.doubleValue()));
            }
        });

        skillFilterComboBox.getItems().add("All Skills");
        resourceService.getAllEmployees().forEach(e ->
                e.getSkills().forEach(skill -> {
                    if (!skillFilterComboBox.getItems().contains(skill)) {
                        skillFilterComboBox.getItems().add(skill);
                    }
                })
        );

        employeeComboBox.setConverter(new StringConverter<Employee>() {
            @Override
            public String toString(Employee employee) {
                return employee == null ? "" : employee.getName();
            }

            @Override
            public Employee fromString(String string) {
                return null; // combo box not editable so never called
            }
        });
        employeeComboBox.getItems().addAll(resourceService.getAllEmployees());
        newHoursField.textProperty().addListener((obs, oldVal, newVal) -> handleLiveBalancing());
        employeeComboBox.valueProperty().addListener((obs, oldVal, newVal) -> handleLiveBalancing());
    }

    @FXML
    public void handleConfirm() {
        Employee selectedEmployee = employeeComboBox.getValue();
        String role = roleField.getText();

        try {
            double hours = Double.parseDouble(newHoursField.getText());
            resourceService.assignTeamMember(project, selectedEmployee, role, hours);
            Stage stage = (Stage) confirmBtn.getScene().getWindow();
            stage.close();
        } catch (OverAllocationException e) {
            projectedLoadLabel.setText(e.getMessage());
            projectedLoadLabel.getStyleClass().setAll("projected-load-label", "load-over");
        } catch (NumberFormatException ex) {
            projectedLoadLabel.setText("Enter a valid number of hours");
            projectedLoadLabel.getStyleClass().setAll("projected-load-label", "load-over");
        }
    }

    @FXML
    public void handleSkillFilter(){
        String selectedSkill = skillFilterComboBox.getValue();
        employeeComboBox.setItems(resourceService.getEmployeesBySkill(selectedSkill));
        employeeComboBox.getSelectionModel().clearSelection();
    }

    @FXML
    public void handleLiveBalancing() {
        Employee selectedEmployee = employeeComboBox.getValue();

        // initialize labels and button
        if (selectedEmployee == null) {
            currentWorkloadTable.setItems(FXCollections.observableArrayList());
            projectedLoadLabel.setText("0 / 40 hrs");
            projectedLoadLabel.getStyleClass().setAll("projected-load-label");
            confirmBtn.setDisable(true);
            return;
        }

        ObservableList<Assignment> currentAssignments = resourceService.getAssignmentsByEmployee(selectedEmployee);
        currentWorkloadTable.setItems(currentAssignments);

        double newHours;
        try {
            newHours = Double.parseDouble(newHoursField.getText());
        } catch (NumberFormatException ex) {
            newHours = 0;
        }

        double currentHours = currentAssignments.stream()
                .mapToDouble(Assignment::getAllocatedHours)
                .sum();
        double total = currentHours + newHours;

        projectedLoadLabel.setText(String.format("%.1f / 40 hrs", total));

        if (total > 40) {
            projectedLoadLabel.getStyleClass().setAll("projected-load-label", "load-over");
            confirmBtn.setDisable(true);
        } else {
            projectedLoadLabel.getStyleClass().setAll("projected-load-label", "load-ok");
            confirmBtn.setDisable(false);
        }
    }

    @FXML
    public void handleCancel() {
        Stage stage = (Stage) confirmBtn.getScene().getWindow();
        stage.close();
    }
}
