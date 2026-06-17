/**********************************************
 Workshop #2
 Course: APD545 - Semester 5
 Last Name: Lo
 First Name: Andrew
 ID: 162539217
 Section:NBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Andrew Lo
 Date: June 6th, 2026
 **********************************************/

package ca.senecacollege.application.controllers;

import ca.senecacollege.application.models.MaintenanceRecord;
import ca.senecacollege.application.models.UsageLog;
import ca.senecacollege.application.models.Vehicle;
import ca.senecacollege.application.services.MaintenanceService;
import ca.senecacollege.application.services.UsageService;
import ca.senecacollege.application.services.VehicleService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.List;

public class SummaryController {
    private VehicleService vService;
    private MaintenanceService mService;
    private UsageService uService;

    @FXML
    private ComboBox<String> dataTypeCombo;
    @FXML private TableView summaryTable;
    @FXML private TableColumn<Vehicle, String> makeCol;
    @FXML private TableColumn<Vehicle, String> modelCol;
    @FXML private TableColumn<Vehicle, Integer> yearCol;
    @FXML private TableColumn<Vehicle, String> typeCol;
    @FXML private Button closeBtn;

    public void setServices(VehicleService v, MaintenanceService m, UsageService u) {
        this.vService = v;
        this.mService = m;
        this.uService = u;
        initializeControls();
    }

    public void initializeControls() {
        dataTypeCombo.getItems().addAll("Vehicles", "Usage Logs", "Maintenance Records");
        dataTypeCombo.setOnAction(e -> updateTable());
    }

    private void updateTable() {
        summaryTable.getColumns().clear(); // wipe old columns
        summaryTable.getItems().clear();   // wipe old data

        String selected = dataTypeCombo.getValue();

        if (selected.equals("Vehicles")) {
            showVehicles();
        } else if (selected.equals("Usage Logs")) {
            showUsageLogs();
        } else if (selected.equals("Maintenance Records")) {
            showMaintenanceRecords();
        }
    }

    private void showVehicles() {
        TableColumn<Vehicle, String> makeCol = new TableColumn<>("Make");
        makeCol.setCellValueFactory(new PropertyValueFactory<>("make"));

        TableColumn<Vehicle, String> modelCol = new TableColumn<>("Model");
        modelCol.setCellValueFactory(new PropertyValueFactory<>("model"));

        TableColumn<Vehicle, Integer> yearCol = new TableColumn<>("Year");
        yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));

        TableColumn<Vehicle, String> typeCol = new TableColumn<>("Type");
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));

        summaryTable.getColumns().addAll(makeCol, modelCol, yearCol, typeCol);
        summaryTable.getItems().addAll(vService.getAllVehicles());
    }

    private void showUsageLogs() {
        TableColumn<UsageLog, String> vehicleCol = new TableColumn<>("Vehicle");
        vehicleCol.setCellValueFactory(new PropertyValueFactory<>("vehicle"));

        TableColumn<UsageLog, LocalDate> startCol = new TableColumn<>("Start Date");
        startCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));

        TableColumn<UsageLog, LocalDate> endCol = new TableColumn<>("End Date");
        endCol.setCellValueFactory(new PropertyValueFactory<>("endDate"));

        TableColumn<UsageLog, Double> distanceCol = new TableColumn<>("KM Driven");
        distanceCol.setCellValueFactory(new PropertyValueFactory<>("distance"));

        summaryTable.getColumns().addAll(vehicleCol, startCol, endCol, distanceCol);

        // need to get logs for ALL vehicles
        for (Vehicle v : vService.getAllVehicles()) {
            List<UsageLog> logs = uService.getLogs(v);
            if (logs != null) {
                summaryTable.getItems().addAll(logs);
            }
        }
    }

    private void showMaintenanceRecords() {
        TableColumn<MaintenanceRecord, LocalDate> dateCol = new TableColumn<>("Date");
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<MaintenanceRecord, String> descCol = new TableColumn<>("Description");
        descCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<MaintenanceRecord, Double> costCol = new TableColumn<>("Cost");
        costCol.setCellValueFactory(new PropertyValueFactory<>("cost"));

        summaryTable.getColumns().addAll(dateCol, descCol, costCol);

        for (Vehicle v : vService.getAllVehicles()) {
            List<MaintenanceRecord> records = mService.getRecords(v);
            if (records != null) {
                summaryTable.getItems().addAll(records);
            }
        }
    }

    @FXML
    public void closeSummary(){
        closeBtn.getScene().getWindow().hide();
    }
}
