package ca.senecacollege.application.workshop3.controllers;

import ca.senecacollege.application.workshop3.enums.PaymentFrequency;
import ca.senecacollege.application.workshop3.models.FixedRateLoan;
import ca.senecacollege.application.workshop3.models.Loan;
import ca.senecacollege.application.workshop3.repository.LoanRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.stage.Stage;

import java.io.IOException;

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
    @FXML private TextField       txtName;
    @FXML private TextField       txtPhone;
    @FXML private TextField       txtCity;
    @FXML private ComboBox<String> cmbProvince;
    @FXML private Label           lblNameError;
    @FXML private Label           lblPhoneError;
    @FXML private Label           lblCityError;
    @FXML private Label           lblProvinceError;

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

    // saved rates
    @FXML private ListView<String> listSavedRates;

    // sub-controllers
    private CustomerController customerController = new CustomerController();
    private VehicleController  vehicleController  = new VehicleController();

    // dependencies
    private LoanRepository  loanRepository;
    private FixedRateLoan   loanCalculator = new FixedRateLoan();
    private Loan            lastCalculatedLoan;

    public void setLoanRepository(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @FXML
    public void initialize() {
        customerController.setFields(
            txtName, txtPhone, txtCity, cmbProvince,
            lblNameError, lblPhoneError, lblCityError, lblProvinceError
        );

        vehicleController.setFields(
            rbCar, rbTruck, rbVan, tgVehicleType, lblVehicleTypeError,
            rbNew, rbUsed, tgVehicleAge, txtVehiclePrice, lblPriceError
        );

        // show/hide custom rate field based on radio selection
        rbOther.selectedProperty().addListener((obs, wasSelected, isSelected) -> {
            txtCustomRate.setVisible(isSelected);
            txtCustomRate.setManaged(isSelected);
        });
    }

    @FXML
    private void handleDurationChange(MouseEvent event) {
        int months = (int) sliderDuration.getValue();
        lblDurationValue.setText(months + " months");
    }

    @FXML
    private void handleClear(ActionEvent event) {
        customerController.clear();
        vehicleController.clear();

        txtDownPayment.clear();
        lblDownPaymentError.setText("");
        rb199.setSelected(true);
        txtCustomRate.clear();
        txtCustomRate.setVisible(false);
        txtCustomRate.setManaged(false);
        sliderDuration.setValue(60);
        lblDurationValue.setText("60 months");
        rbBiweekly.setSelected(true);
        lblFrequencyDesc.setText("Bi-weekly · 60 months · 1.99% APR");
        lblEstimatedPayment.setText("$0.00");

        lastCalculatedLoan = null;
    }

    @FXML
    private void handleCalculate(ActionEvent event) {
        lblDownPaymentError.setText("");

        boolean customerValid = customerController.validateCustomer();
        boolean vehicleValid  = vehicleController.validateVehicle();

        if (!customerValid || !vehicleValid) return;

        // validate down payment (empty = 0)
        double downPayment = 0;
        String downPaymentText = txtDownPayment.getText().trim();
        if (!downPaymentText.isEmpty()) {
            try {
                downPayment = Double.parseDouble(downPaymentText);
                if (downPayment < 0) {
                    lblDownPaymentError.setText("Down payment cannot be negative.");
                    return;
                }
            } catch (NumberFormatException e) {
                lblDownPaymentError.setText("Enter a valid amount.");
                return;
            }
        }

        // get interest rate
        double interestRate;
        if (rb099.isSelected())       interestRate = 0.99;
        else if (rb199.isSelected())  interestRate = 1.99;
        else if (rb299.isSelected())  interestRate = 2.99;
        else {
            try {
                interestRate = Double.parseDouble(txtCustomRate.getText().trim());
                if (interestRate < 0) {
                    lblDownPaymentError.setText("Interest rate cannot be negative.");
                    return;
                }
            } catch (NumberFormatException e) {
                lblDownPaymentError.setText("Enter a valid interest rate.");
                return;
            }
        }

        // get frequency
        PaymentFrequency frequency;
        if (rbWeekly.isSelected())        frequency = PaymentFrequency.WEEKLY;
        else if (rbMonthly.isSelected())  frequency = PaymentFrequency.MONTHLY;
        else                              frequency = PaymentFrequency.BIWEEKLY;

        int duration = (int) sliderDuration.getValue();

        // build loan
        Loan loan = new Loan();
        loan.setCustomer(customerController.getCustomer());
        loan.setVehicle(vehicleController.getVehicle());
        loan.setDownPayment(downPayment);
        loan.setInterestRate(interestRate);
        loan.setDuration(duration);
        loan.setFrequency(frequency);

        double payment = loanCalculator.calculatePayment(loan);
        lastCalculatedLoan = loan;

        lblEstimatedPayment.setText(String.format("$%.2f", payment));

        String freqLabel = switch (frequency) {
            case WEEKLY   -> "Weekly";
            case BIWEEKLY -> "Bi-weekly";
            case MONTHLY  -> "Monthly";
        };
        lblFrequencyDesc.setText(freqLabel + " · " + duration + " months · " + interestRate + "% APR");
    }

    @FXML
    private void handleSaveRate(ActionEvent event) {
        if (lastCalculatedLoan == null) {
            lblEstimatedPayment.setText("Calculate first.");
            return;
        }

        loanRepository.saveLoan(lastCalculatedLoan);

        String freqLabel = switch (lastCalculatedLoan.getFrequency()) {
            case WEEKLY   -> "weekly";
            case BIWEEKLY -> "bi-weekly";
            case MONTHLY  -> "monthly";
        };

        double payment = loanCalculator.calculatePayment(lastCalculatedLoan);
        String entry = String.format("%s — $%.2f %s · %d mo · %.2f%%",
            lastCalculatedLoan.getCustomer().getName(),
            payment,
            freqLabel,
            lastCalculatedLoan.getDuration(),
            lastCalculatedLoan.getInterestRate()
        );

        listSavedRates.getItems().add(entry);
    }

    @FXML
    private void handleViewAmortization(ActionEvent event) throws IOException {
        if (lastCalculatedLoan == null) {
            lblEstimatedPayment.setText("Calculate first.");
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource(
            "/ca/senecacollege/application/workshop3/Amortization.fxml"
        ));
        Parent root = loader.load();
        LoanAmortizationController amortController = loader.getController();
        amortController.setPreviousScene(btnViewAmortization.getScene());
        amortController.setLoan(lastCalculatedLoan);

        Stage stage = (Stage) btnViewAmortization.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}
