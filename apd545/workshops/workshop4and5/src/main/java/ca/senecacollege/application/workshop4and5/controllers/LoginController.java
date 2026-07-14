package ca.senecacollege.application.workshop4and5.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Controller for the Login screen (login-view.fxml).
 * Screen 1: Secure entry to the system.
 * <p>
 * NOTE: Credential validation, window transitions and error handling will be
 * wired up in the backend (DIY) step once AuthenticationService exists.
 */
public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label statusLabel;

    @FXML
    private void initialize() {
        statusLabel.setText("");
    }

    @FXML
    private void handleLogin() {
        // TODO (backend step): call AuthenticationService.authenticate(username, password)
        // On success: close this window and open the Portfolio Dashboard.
        // On failure: statusLabel.setText("Invalid Credentials");
    }
}
