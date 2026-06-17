/**********************************************
 Workshop #2
 Course: APD545 - Semester 5
 Last Name: Lo
 First Name: Andrew
 ID: 162539217
 Section:NBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Andrew Lo
 Date: June 6th, 2026
 **********************************************/

package ca.senecacollege.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 600);
        stage.setTitle("Main");
        stage.setScene(scene);
        stage.show();
    }
}
