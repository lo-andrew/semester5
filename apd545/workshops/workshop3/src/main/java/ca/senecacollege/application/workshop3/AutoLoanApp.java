package ca.senecacollege.application.workshop3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AutoLoanApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AutoLoanApp.class.getResource("/ca/senecacollege/application/workshop3/Homepage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 900);
        stage.setTitle("Auto Loan");
        stage.setScene(scene);
        stage.show();
    }
}
