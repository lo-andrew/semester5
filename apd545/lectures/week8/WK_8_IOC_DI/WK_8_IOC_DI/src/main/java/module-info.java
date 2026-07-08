module ca.senecacollege.application.wk_8_ioc_di {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.common;
    requires com.google.guice;


    opens ca.senecacollege.application.wk_8_ioc_di to javafx.fxml;
    exports ca.senecacollege.application.wk_8_ioc_di;

    exports ca.senecacollege.application.controllers;
    opens ca.senecacollege.application.controllers to javafx.fxml;
    exports ca.senecacollege.application.utility to com.google.guice;
    exports ca.senecacollege.application.repositories to com.google.guice;
}