package ca.senecacollege.application.workshop4and5;

import ca.senecacollege.application.workshop4and5.di.AppModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
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

    private Injector injector;

    @Override
    public void init() {
        // Runs once, before start(). Builds the whole object graph (repositories,
        // services) up front so every controller can simply declare what it
        // needs in its constructor instead of reaching for it manually.
        injector = Guice.createInjector(new AppModule());
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("login-view.fxml"));

        // Tells FXMLLoader to build the controller via Guice (injector::getInstance)
        // instead of calling a no-arg constructor itself. Guice resolves whatever
        // the controller's @Inject constructor asks for (services/repositories),
        // then FXMLLoader takes over to inject the @FXML fields and call initialize().
        fxmlLoader.setControllerFactory(injector::getInstance);

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Nexus Consulting - Decision Support System");
        stage.setScene(scene);
        stage.show();
    }
}
