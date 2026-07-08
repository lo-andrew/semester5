module ca.senecacollege.application.wk3_firstfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.senecacollege.application.wk3_firstfx to javafx.fxml;
    exports ca.senecacollege.application.wk3_firstfx;
}