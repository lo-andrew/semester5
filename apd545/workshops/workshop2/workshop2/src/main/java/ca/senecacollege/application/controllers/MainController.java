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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;

public class MainController {

    private VehicleService vService = new VehicleService();
    private MaintenanceService mService = new MaintenanceService();
    private UsageService uService = new UsageService();

    // the three forms
    @FXML private GridPane addVehicleForm;
    @FXML private GridPane addUsageForm;
    @FXML private GridPane addMaintenanceForm;

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
    public void showAddVehicleForm(){
        addVehicleForm.setVisible(true);
        addUsageForm.setVisible(false);
        addMaintenanceForm.setVisible(false);
    }

    @FXML
    public void showAddUsageForm() {
        addVehicleForm.setVisible(false);
        addUsageForm.setVisible(true);
        addMaintenanceForm.setVisible(false);
    }

    @FXML
    public void showAddMaintenanceForm() {
        addVehicleForm.setVisible(false);
        addUsageForm.setVisible(false);
        addMaintenanceForm.setVisible(true);
    }

    @FXML
    public void initialize() {
        vehicleType.getItems().addAll("Sedan", "Truck", "SUV", "Van", "Motorcycle");
        showAddVehicleForm();
    }

    @FXML
    public void addVehicle() {
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
    public void saveUsageRecord() {
        LocalDate start = usageStart.getValue();
        LocalDate end = usageEnd.getValue();
        double distance = Double.parseDouble(usageDistance.getText());
        Vehicle selectedVehicle = usageVehicle.getValue();

        UsageLog log = new UsageLog(selectedVehicle, start, end, distance);
        uService.addLog(selectedVehicle, log);
    }

    @FXML
    public void saveMaintenanceRecord() {
        LocalDate date = maintenanceDate.getValue();
        double cost = Double.parseDouble(maintenanceCost.getText());
        String description = maintenanceDesc.getText();

        Vehicle selectedVehicle = maintenanceVehicle.getValue();
        MaintenanceRecord record = new MaintenanceRecord(selectedVehicle, date, cost, description);
        mService.addRecord(selectedVehicle, record);
    }

    @FXML
    public void openSummary() {
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
