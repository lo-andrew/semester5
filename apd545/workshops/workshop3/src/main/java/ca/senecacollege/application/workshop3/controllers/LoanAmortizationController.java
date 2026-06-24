package ca.senecacollege.application.workshop3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class LoanAmortizationController {

    @FXML private Button    btnBack;

    // Summary labels
    @FXML private Label     lblVehiclePrice;
    @FXML private Label     lblDownPayment;
    @FXML private Label     lblTotalInterest;
    @FXML private Label     lblTotalCost;

    // Table
    @FXML private TableView<?>      tableAmortization;
    @FXML private TableColumn<?, ?> colDate;
    @FXML private TableColumn<?, ?> colMonth;
    @FXML private TableColumn<?, ?> colPayment;
    @FXML private TableColumn<?, ?> colPrincipal;
    @FXML private TableColumn<?, ?> colInterest;
    @FXML private TableColumn<?, ?> colBalance;

    @FXML
    private void handleBack(ActionEvent event) {}
}
