package ca.senecacollege.application.workshop4and5.controllers;

import ca.senecacollege.application.workshop4and5.data.EmployeeRepository;
import ca.senecacollege.application.workshop4and5.services.ResourceService;
import com.google.inject.Inject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * Controller for the Resource Allocator dialog (resource-allocator.fxml).
 * Screen 3: Assign staff to a project and resolve scheduling conflicts.
 * <p>
 * NOTE: Left untyped/unwired pending the domain models and ResourceService
 * (backend DIY step). Planned wiring once those exist:
 *   - employeeComboBox selection -&gt; service.getAssignmentsByEmployee(e) -&gt; currentWorkloadTable
 *   - listener on newHoursField -&gt; recompute projectedLoadLabel; toggle its style class
 *     between "load-ok" and "load-over" (see app.css) instead of setting colors inline
 *   - confirmBtn disabled while projected load &gt; 40
 *   - cancelBtn discards any edits made to currentWorkloadTable without mutating live objects
 */
public class AllocatorController {

    @FXML
    private ComboBox<String> skillFilterComboBox;

    @FXML
    private ComboBox<String> employeeComboBox;

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
    private TableView<Object> currentWorkloadTable;

    @FXML
    private TableColumn<Object, String> workloadProjectColumn;

    @FXML
    private TableColumn<Object, String> workloadRoleColumn;

    @FXML
    private TableColumn<Object, Number> workloadHoursColumn;

    @FXML
    private TableColumn<Object, Number> workloadCostColumn;

    private final EmployeeRepository empRepo;
    private final ResourceService resourceService;

    @Inject
    public AllocatorController(EmployeeRepository empRepo, ResourceService resourceService) {
        this.empRepo = empRepo;
        this.resourceService = resourceService;
    }

    @FXML
    private void initialize() {
        projectedLoadLabel.setText("0 / 40 hrs");
        // TODO (backend step): populate skillFilterComboBox/employeeComboBox from EmployeeRepository,
        // and add the live-hours listener described above.
    }

    @FXML
    public void handleConfirm() {
        // TODO (backend step): call service.assignTeamMember(project, employee, hours);
        // catch OverAllocationException; close dialog on success.
    }

    @FXML
    public void handleSkillFilter(){

    }

    @FXML
    public void handleLiveBalancing(){

    }

    @FXML
    public void handleCancel() {
        // TODO (backend step): discard any in-progress edits to currentWorkloadTable and close the dialog.
    }
}
