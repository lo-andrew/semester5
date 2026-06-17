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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class MainController {

    private VehicleService vService = new VehicleService();
    private MaintenanceService mService = new MaintenanceService();
    private UsageService uService = new UsageService();

    // addVehicle form fields
    @FXML private TextField vehicleMake;
    @FXML private TextField vehicleModel;
    @FXML private TextField vehicleYear;
    @FXML private ComboBox<String> vehicleType;

    // usage form fields
    @FXML private ComboBox<Vehicle> usageVehicle;
    @FXML private DatePicker usageStart;
    @FXML private DatePicker usageEnd;
    @FXML private TextField usageDistance;

    // maintenance form fields
    @FXML private ComboBox<Vehicle> maintenanceVehicle;
    @FXML private DatePicker maintenanceDate;
    @FXML private TextField maintenanceDesc;
    @FXML private TextField maintenanceCost;

    @FXML
    public void initialize() {
        vehicleType.getItems().addAll("Sedan", "Truck", "SUV", "Van", "Motorcycle");
    }

    @FXML
    public void onSaveVehicle() {
        String make = vehicleMake.getText();
        String model = vehicleModel.getText();
        int year = Integer.parseInt(vehicleYear.getText());
        String type = vehicleType.getValue();

        Vehicle v = new Vehicle(make, model, year, type);
        vService.addVehicle(v);

        // update the vehicle dropdowns in the other forms
        usageVehicle.getItems().add(v);
        maintenanceVehicle.getItems().add(v);
    }

    @FXML
    public void onSaveUsage() {
        LocalDate start = usageStart.getValue();
        LocalDate end = usageEnd.getValue();
        double distance = Double.parseDouble(usageDistance.getText());
        Vehicle selectedVehicle = usageVehicle.getValue();

        UsageLog log = new UsageLog(selectedVehicle, start, end, distance);
        uService.addLog(selectedVehicle, log);
    }

    @FXML
    public void onSaveMaintenance() {
        LocalDate date = maintenanceDate.getValue();
        double cost = Double.parseDouble(maintenanceCost.getText());
        String description = maintenanceDesc.getText();

        Vehicle selectedVehicle = maintenanceVehicle.getValue();
        MaintenanceRecord record = new MaintenanceRecord(selectedVehicle, date, cost, description);
        mService.addRecord(selectedVehicle, record);
    }

    @FXML
    public void onOpenSummary() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ca/senecacollege/application/SummaryView.fxml"));
            Parent root = loader.load();

            SummaryController summaryController = loader.getController();
            summaryController.setServices(vService, mService, uService);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Summary");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
