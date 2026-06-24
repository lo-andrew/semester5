package ca.senecacollege.application.workshop3.controllers;

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

    @FXML
    private void handleSignup(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ca/senecacollege/application/workshop3/Signup.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) btnSignup.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    private void handleLogin(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ca/senecacollege/application/workshop3/Login.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) btnSignup.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}