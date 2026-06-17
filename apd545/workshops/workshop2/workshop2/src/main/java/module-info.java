/**********************************************
 Workshop #2
 Course: APD545 - Semester 5
 Last Name: Lo
 First Name: Andrew
 ID: 162539217
 Section:NBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Andrew Lo
 Date: June 6th, 2026
 **********************************************/

module ca.senecacollege.application.workshop2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.senecacollege.application to javafx.fxml;
    exports ca.senecacollege.application;
    exports ca.senecacollege.application.controllers;
    opens ca.senecacollege.application.controllers to javafx.fxml;
    opens ca.senecacollege.application.models to javafx.base;
    exports ca.senecacollege.application.models;
}