package ca.senecacollege.application.workshop4and5;

import ca.senecacollege.application.workshop4and5.di.AppModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private Injector injector;

    @Override
    public void init() {
        // every controller declares what it needs in its constructor instead getting it manually
        injector = Guice.createInjector(new AppModule());
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("login-view.fxml"));
        // FXMLLoader takes over to inject the FXML fields and calls initialize
        fxmlLoader.setControllerFactory(injector::getInstance);

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Nexus Consulting - Decision Support System");
        stage.setScene(scene);
        stage.show();
    }
}
