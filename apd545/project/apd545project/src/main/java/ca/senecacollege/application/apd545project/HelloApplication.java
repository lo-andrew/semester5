package ca.senecacollege.application.apd545project;

import ca.senecacollege.application.apd545project.app.AppConfig;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        AppConfig appConfig = new AppConfig(stage);

        FXMLLoader shellLoader = new FXMLLoader(
            getClass().getResource("/ca/senecacollege/application/apd545project/view/kiosk-shell.fxml")
        );
        shellLoader.setControllerFactory(c -> appConfig.getKioskController());

        Scene scene = new Scene(shellLoader.load(), 960, 600);

        appConfig.getKioskController().showInitialView();

        stage.setTitle("The Seneca Hotel");
        stage.setScene(scene);
        stage.show();
    }
}
