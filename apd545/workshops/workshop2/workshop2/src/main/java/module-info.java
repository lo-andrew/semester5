module ca.senecacollege.application.workshop2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.senecacollege.application to javafx.fxml;
    exports ca.senecacollege.application;
    exports ca.senecacollege.application.controllers;
    opens ca.senecacollege.application.controllers to javafx.fxml;
    exports ca.senecacollege.application.vmum_windows;
    opens ca.senecacollege.application.vmum_windows to javafx.fxml;
}