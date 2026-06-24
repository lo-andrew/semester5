package ca.senecacollege.application.workshop3.controllers;

import ca.senecacollege.application.workshop3.models.AmortizationEntry;
import ca.senecacollege.application.workshop3.models.Loan;
import ca.senecacollege.application.workshop3.services.AmortizationService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.List;

public class LoanAmortizationController {

    @FXML private Button    btnBack;

    @FXML private Label     lblVehiclePrice;
    @FXML private Label     lblDownPayment;
    @FXML private Label     lblTotalInterest;
    @FXML private Label     lblTotalCost;

    @FXML private TableView<AmortizationEntry>      tableAmortization;
    @FXML private TableColumn<AmortizationEntry, String>  colDate;
    @FXML private TableColumn<AmortizationEntry, Integer> colMonth;
    @FXML private TableColumn<AmortizationEntry, Double>  colPayment;
    @FXML private TableColumn<AmortizationEntry, Double>  colPrincipal;
    @FXML private TableColumn<AmortizationEntry, Double>  colInterest;
    @FXML private TableColumn<AmortizationEntry, Double>  colBalance;

    private Scene previousScene;
    private final AmortizationService amortizationService = new AmortizationService();

    public void setPreviousScene(Scene scene) {
        this.previousScene = scene;
    }

    public void setLoan(Loan loan) {
        // summary labels
        lblVehiclePrice.setText(String.format("$%.2f", loan.getVehicle().getPrice()));
        lblDownPayment.setText(String.format("$%.2f", loan.getDownPayment()));

        // generate schedule
        List<AmortizationEntry> schedule = amortizationService.generateSchedule(loan);

        double totalInterest = schedule.stream().mapToDouble(AmortizationEntry::getInterest).sum();
        double totalCost     = loan.getDownPayment() + schedule.stream().mapToDouble(AmortizationEntry::getPayment).sum();

        lblTotalInterest.setText(String.format("$%.2f", totalInterest));
        lblTotalCost.setText(String.format("$%.2f", totalCost));

        // wire table columns
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colMonth.setCellValueFactory(new PropertyValueFactory<>("month"));
        colPayment.setCellValueFactory(new PropertyValueFactory<>("payment"));
        colPrincipal.setCellValueFactory(new PropertyValueFactory<>("principal"));
        colInterest.setCellValueFactory(new PropertyValueFactory<>("interest"));
        colBalance.setCellValueFactory(new PropertyValueFactory<>("balance"));

        // format currency columns
        formatCurrencyColumn(colPayment);
        formatCurrencyColumn(colPrincipal);
        formatCurrencyColumn(colInterest);
        formatCurrencyColumn(colBalance);

        tableAmortization.setItems(FXCollections.observableArrayList(schedule));
    }

    private void formatCurrencyColumn(TableColumn<AmortizationEntry, Double> col) {
        col.setCellFactory(_ -> new javafx.scene.control.TableCell<>() {
            @Override
            protected void updateItem(Double value, boolean empty) {
                super.updateItem(value, empty);
                setText(empty || value == null ? null : String.format("$%.2f", value));
            }
        });
    }

    @FXML
    private void handleBack(ActionEvent event) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(previousScene);
    }
}
