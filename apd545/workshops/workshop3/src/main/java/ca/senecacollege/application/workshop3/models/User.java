/**********************************************
 Workshop # 3
 Course:APD545 - Semester 5
 Last Name: Lo
 First Name: Andrew
 ID: 162539217
 Section: NBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: June 26th, 2026
 **********************************************/
package ca.senecacollege.application.workshop3.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private final StringProperty username = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();
    private final StringProperty email = new SimpleStringProperty();

    public User(String username, String password, String email) {
        this.username.set(username);
        this.password.set(password);
        this.email.set(email);
    }

    public String getUsername() {
        return username.get();
    }
    public void setUsername(String value){
        username.set(value);
    }
    public StringProperty usernameProperty() {
        return username;
    }

    public String getPassword() {
        return password.get();
    }
    public void setPassword(String value) {
        password.set(value);
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public String getEmail() {
        return email.get();
    }
    public void setEmail(String value) {
        email.set(value);
    }
    public StringProperty emailProperty() {
        return email;
    }
}
