package ca.senecacollege.application.workshop3.controllers;

import ca.senecacollege.application.workshop3.repository.LoanRepository;
import ca.senecacollege.application.workshop3.repository.UserRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomepageController {

    @FXML private Button btnSignup;
    @FXML private Button btnLogin;

    private UserRepository userRepo;
    private LoanRepository loanRepo;

    public void setUserRepository(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void setLoanRepository(LoanRepository loanRepo) {
        this.loanRepo = loanRepo;
    }

    @FXML
    private void handleSignup(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ca/senecacollege/application/workshop3/Signup.fxml"));
        Parent root = loader.load();
        SignupController signupController = loader.getController();
        signupController.setUserRepository(userRepo);
        signupController.setLoanRepository(loanRepo);
        Stage stage = (Stage) btnSignup.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ca/senecacollege/application/workshop3/Login.fxml"));
        Parent root = loader.load();
        LoginController loginController = loader.getController();
        loginController.setUserRepository(userRepo);
        loginController.setLoanRepository(loanRepo);
        Stage stage = (Stage) btnSignup.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}