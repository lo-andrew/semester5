module ca.senecacollege.application.workshop3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;


    opens ca.senecacollege.application.workshop3 to javafx.fxml, javafx.graphics;
    opens ca.senecacollege.application.workshop3.controllers to javafx.fxml;
}