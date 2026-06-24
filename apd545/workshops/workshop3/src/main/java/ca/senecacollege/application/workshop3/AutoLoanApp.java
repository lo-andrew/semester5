package ca.senecacollege.application.workshop3;

import ca.senecacollege.application.workshop3.controllers.HomepageController;
import ca.senecacollege.application.workshop3.models.User;
import ca.senecacollege.application.workshop3.repository.LoanRepository;
import ca.senecacollege.application.workshop3.repository.UserRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AutoLoanApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        UserRepository userRepository = new UserRepository();
        LoanRepository loanRepository = new LoanRepository();

        userRepository.addUser(new User("user1", "password123", "testuser@email.com"));
        userRepository.addUser(new User("user2", "pass", "testing@email.com"));

        FXMLLoader fxmlLoader = new FXMLLoader(AutoLoanApp.class.getResource("/ca/senecacollege/application/workshop3/Homepage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 900);

        HomepageController controller = fxmlLoader.getController();
        controller.setUserRepository(userRepository); // inject it
        controller.setLoanRepository(loanRepository);

        stage.setTitle("Auto Loan");
        stage.setScene(scene);
        stage.show();
    }
}
