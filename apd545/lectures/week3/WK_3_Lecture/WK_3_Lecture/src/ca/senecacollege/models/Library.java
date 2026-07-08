package ca.senecacollege.models;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String,  Book> books;
    private Map<String, User> users;

    public Library(){
        books = new HashMap<>();
        users= new HashMap<>();
    }

    public Book getBooks(String isbn) {
        return books.get(isbn);
    }

    public void addBooks(Book book) {
        books.put(book.getIsbn(), book);
    }

    public User getUsers(String userId) {
        return users.get(userId);
    }

    public void addUsers(User user) {
        users.put(user.getUserID(), user);
    }

    public void displayBooks(){
        for(Map.Entry<String, Book> entry: books.entrySet())
            System.out.println(entry.getValue());
    }

    public void displayUsers(){
        for(Map.Entry<String, User> entry : users.entrySet())
            System.out.println(entry.getValue());
    }
}
