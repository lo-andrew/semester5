package ca.senecacollege.services;

import ca.senecacollege.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserServices {
    private Map<String, User> users;
    public UserServices() {
        users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getUserID(), user);
    }

    public User getUser(String isbn){
        return users.get(isbn);
    }
    public void removeUser(String isbn){
        users.remove(isbn);
    }
    public void displayUsers(){
//        for(User user : users.values()){
//            System.out.println(user);
//        }
        users.values().stream().forEach(System.out::println);
    }
}
