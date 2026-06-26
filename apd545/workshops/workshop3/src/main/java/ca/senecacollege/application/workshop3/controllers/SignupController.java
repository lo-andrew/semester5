/**********************************************
 Workshop # 3
 Course:APD545 - Semester 5
 Last Name: Lo
 First Name: Andrew
 ID: 162539217
 Section: NBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: June 26th, 2026
 **********************************************/
package ca.senecacollege.application.workshop3.controllers;

import ca.senecacollege.application.workshop3.models.User;
import ca.senecacollege.application.workshop3.repository.LoanRepository;
import ca.senecacollege.application.workshop3.repository.UserRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupController {

    @FXML private TextField txtUsername;
    @FXML private TextField txtEmail;
    @FXML private PasswordField txtPassword;
    @FXML private PasswordField txtConfirmPassword;
    @FXML private Label lblPasswordError;
    @FXML private Label lblConfirmError;
    @FXML private Label lblGeneralError;
    @FXML private Button btnCreateAccount;
    @FXML private Hyperlink linkLogin;

    private UserRepository userRepo;
    private LoanRepository loanRepo;

    public void setUserRepository(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void setLoanRepository(LoanRepository loanRepo) {
        this.loanRepo = loanRepo;
    }

    @FXML
    private void handleSignup(ActionEvent event) throws IOException{
        String username = txtUsername.getText().trim();
        String password = txtPassword.getText();
        String confirm = txtConfirmPassword.getText();
        String email = txtEmail.getText().trim();

        if (!password.equals(confirm)) {
            lblConfirmError.setText("Passwords do not match.");
            return;
        }

        if (username.isEmpty() || email.isEmpty()) {
            lblGeneralError.setText("All fields are required.");
            return;
        }

        User user = new User(username, password, email);
        userRepo.addUser(user);

        // go to login page after signing up
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ca/senecacollege/application/workshop3/Login.fxml"));
        Parent root = loader.load();
        LoginController loginController = loader.getController();
        loginController.setUserRepository(userRepo);
        loginController.setLoanRepository(loanRepo);
        Stage stage = (Stage) btnCreateAccount.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    private void handleGoToLogin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ca/senecacollege/application/workshop3/Login.fxml"));
        Parent root = loader.load();
        LoginController loginController = loader.getController();
        loginController.setUserRepository(userRepo);
        loginController.setLoanRepository(loanRepo);
        Stage stage = (Stage) linkLogin.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}