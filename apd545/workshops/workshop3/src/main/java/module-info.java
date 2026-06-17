module ca.senecacollege.application.workshop3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.senecacollege.application.workshop3 to javafx.fxml;
    exports ca.senecacollege.application.workshop3;
}