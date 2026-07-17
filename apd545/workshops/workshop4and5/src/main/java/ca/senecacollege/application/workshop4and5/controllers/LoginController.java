package ca.senecacollege.application.workshop4and5.controllers;

import ca.senecacollege.application.workshop4and5.MainApp;
import ca.senecacollege.application.workshop4and5.services.AuthenticationService;
import com.google.inject.Inject;
import com.google.inject.Injector;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.UncheckedIOException;

/**
 * Controller for the Login screen (login-view.fxml).
 * Screen 1: Secure entry to the system.
 */
public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label statusLabel;

    private final AuthenticationService authenticationService;
    private final Injector injector;

    @Inject
    public LoginController(AuthenticationService authenticationService, Injector injector) {
        this.authenticationService = authenticationService;
        this.injector = injector;
    }

    @FXML
    private void initialize() {
        statusLabel.setText("");
    }

    @FXML
    private void handleLogin() {
        if (authenticationService.authenticate(usernameField.getText(), passwordField.getText())) {
            openDashboard();
        } else {
            statusLabel.setText("Invalid Credentials");
        }
    }

    private void openDashboard() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("portfolio-dashboard.fxml"));
            // Same as MainApp.start(): let Guice build the controller so its
            // @Inject constructor gets ProjectRepository/ResourceService.
            loader.setControllerFactory(injector::getInstance);
            Scene dashboardScene = new Scene(loader.load());

            Stage dashboardStage = new Stage();
            dashboardStage.setTitle("Nexus Consulting - Portfolio Dashboard");
            dashboardStage.setScene(dashboardScene);
            dashboardStage.show();
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to load Portfolio Dashboard", e);
        }

        // usernameField is any control on this screen - every node's getScene()
        // points back to the same Scene, and getWindow() on that Scene is the
        // Stage currently showing it. Casting to Stage lets us close it.
        Stage loginStage = (Stage) usernameField.getScene().getWindow();
        loginStage.close();
    }
}
