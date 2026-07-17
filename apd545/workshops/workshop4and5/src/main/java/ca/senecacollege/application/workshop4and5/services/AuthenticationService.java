package ca.senecacollege.application.workshop4and5.services;

import java.util.Objects;

public class AuthenticationService {
    private String username = "manager";
    private String password = "Password1";

    public boolean authenticate(String user, String pass){
        return username.equals(user) && password.equals(pass);
    }
}
