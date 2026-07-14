package ca.senecacollege.application.workshop4and5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Application entry point. Boots the Login screen (Screen 1).
 * On successful authentication the Login window is closed and the
 * Portfolio Dashboard (Screen 2) is opened (wired up in the backend step).
 */
public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Nexus Consulting - Decision Support System");
        stage.setScene(scene);
        stage.show();
    }
}
