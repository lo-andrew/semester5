package ca.senecacollege.application.workshop3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class LoanController {

    // nav
    @FXML private Button btnNavCustomer;
    @FXML private Button btnNavVehicle;
    @FXML private Button btnNavLoan;
    @FXML private Button btnNavSaved;

    // sections
    @FXML private VBox sectionCustomer;
    @FXML private VBox sectionVehicle;
    @FXML private VBox sectionLoan;
    @FXML private VBox sectionSaved;

    // customer
    @FXML private TextField  txtName;
    @FXML private TextField  txtPhone;
    @FXML private TextField  txtCity;
    @FXML private ComboBox<String> cmbProvince;
    @FXML private Label      lblNameError;
    @FXML private Label      lblPhoneError;
    @FXML private Label      lblCityError;
    @FXML private Label      lblProvinceError;

    // vehicle
    @FXML private RadioButton  rbCar;
    @FXML private RadioButton  rbTruck;
    @FXML private RadioButton  rbVan;
    @FXML private ToggleGroup  tgVehicleType;
    @FXML private Label        lblVehicleTypeError;
    @FXML private RadioButton  rbNew;
    @FXML private RadioButton  rbUsed;
    @FXML private ToggleGroup  tgVehicleAge;
    @FXML private TextField    txtVehiclePrice;
    @FXML private Label        lblPriceError;

    // loan
    @FXML private TextField    txtDownPayment;
    @FXML private Label        lblDownPaymentError;
    @FXML private RadioButton  rb099;
    @FXML private RadioButton  rb199;
    @FXML private RadioButton  rb299;
    @FXML private RadioButton  rbOther;
    @FXML private ToggleGroup  tgInterestRate;
    @FXML private TextField    txtCustomRate;
    @FXML private Slider       sliderDuration;
    @FXML private Label        lblDurationValue;
    @FXML private RadioButton  rbWeekly;
    @FXML private RadioButton  rbBiweekly;
    @FXML private RadioButton  rbMonthly;
    @FXML private ToggleGroup  tgFrequency;
    @FXML private Label        lblFrequencyDesc;
    @FXML private Label        lblEstimatedPayment;
    @FXML private Button       btnClear;
    @FXML private Button       btnCalculate;
    @FXML private Button       btnSaveRate;
    @FXML private Button       btnViewAmortization;

    // saved Rates
    @FXML private ListView<String> listSavedRates;

    @FXML private void scrollToCustomer(ActionEvent event) {}
    @FXML private void scrollToVehicle(ActionEvent event) {}
    @FXML private void scrollToLoan(ActionEvent event) {}
    @FXML private void scrollToSaved(ActionEvent event) {}

    @FXML private void handleDurationChange(MouseEvent event) {}
    @FXML private void handleClear(ActionEvent event) {}
    @FXML private void handleCalculate(ActionEvent event) {}
    @FXML private void handleSaveRate(ActionEvent event) {}
    @FXML private void handleViewAmortization(ActionEvent event) {}


    // direct inject to respective controllers
    private CustomerController customerController;
    private VehicleController vehicleController;


}