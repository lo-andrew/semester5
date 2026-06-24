package ca.senecacollege.application.workshop3.repository;

import ca.senecacollege.application.workshop3.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public void addUser(User user){
        users.add(user);
    }
    private User findUser(String user){
        return users.stream().filter(u -> u.getUsername().equals(user)).findFirst().orElse(null);

    }

    public boolean validateLogin(String username, String password){
        User user = findUser(username);
        return user != null && user.getPassword().equals(password);
    }
}
