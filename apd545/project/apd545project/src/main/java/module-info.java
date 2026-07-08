module ca.senecacollege.application.apd545project {
    requires javafx.controls;
    requires javafx.fxml;

    opens ca.senecacollege.application.apd545project to javafx.fxml;
    opens ca.senecacollege.application.apd545project.controller to javafx.fxml;

    exports ca.senecacollege.application.apd545project;
    exports ca.senecacollege.application.apd545project.app;
    exports ca.senecacollege.application.apd545project.controller;
    exports ca.senecacollege.application.apd545project.model;
    exports ca.senecacollege.application.apd545project.util;
}
