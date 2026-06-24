package ca.senecacollege.application.workshop3.controllers;

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

public class LoginController {

    @FXML private TextField     txtUsername;
    @FXML private PasswordField txtPassword;
    @FXML private Label         lblError;
    @FXML private Button        btnLogin;
    @FXML private Hyperlink     linkSignup;

    private UserRepository userRepo;
    private LoanRepository loanRepo;

    public void setUserRepository(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void setLoanRepository(LoanRepository loanRepo) {
        this.loanRepo = loanRepo;
    }

    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
        String username = txtUsername.getText().trim();
        String password = txtPassword.getText().trim();

        if (!userRepo.validateLogin(username, password)) {
            lblError.setText("Invalid username or password.");
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ca/senecacollege/application/workshop3/LoanApplication.fxml"));
        Parent root = loader.load();
        LoanController loanController = loader.getController();
        loanController.setLoanRepository(loanRepo);
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    private void handleGoToSignup(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ca/senecacollege/application/workshop3/Signup.fxml"));
        Parent root = loader.load();
        SignupController signupController = loader.getController();
        signupController.setUserRepository(userRepo);
        Stage stage = (Stage) linkSignup.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}