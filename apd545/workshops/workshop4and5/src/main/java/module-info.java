module ca.senecacollege.application.workshop4and5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.senecacollege.application.workshop4and5 to javafx.fxml;
    exports ca.senecacollege.application.workshop4and5;

    opens ca.senecacollege.application.workshop4and5.controllers to javafx.fxml;
    exports ca.senecacollege.application.workshop4and5.controllers;
}