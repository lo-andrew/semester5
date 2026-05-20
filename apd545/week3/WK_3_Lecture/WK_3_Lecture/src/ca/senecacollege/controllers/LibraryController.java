package ca.senecacollege.controllers;

import ca.senecacollege.models.Book;
import ca.senecacollege.models.BookIssueRecord;
import ca.senecacollege.models.User;
import ca.senecacollege.services.BookServices;
import ca.senecacollege.services.IssuanceServices;
import ca.senecacollege.services.UserServices;

import java.util.Date;

public class LibraryController {

    //now controller can use the services
    private BookServices bookServices;
    private UserServices userServices;
    private IssuanceServices issuanceServices;

    public LibraryController(){
        bookServices = new BookServices();
        userServices = new UserServices();
        issuanceServices = new IssuanceServices();
    }

    //addBook function is going to the call the service to provide the actual funtionality
    public void addBook(String isbn, String title, String author){
        bookServices.addBook(new Book(isbn, title, author));
    }

    public void addUser(String userId, String name){
        userServices.addUser(new User(userId, name));
    }

    public void displayBooks(){
        bookServices.displayBooks();
    }

    public void displayUsers(){
        userServices.displayUsers();
    }

    public void issueBook(String isbn, String userId){
        if(bookServices.getBook(isbn) != null && userServices.getUser(userId) != null
        && issuanceServices.getIssuedBooks().get(isbn) == null){
            issuanceServices.issueBook(isbn, userId, new BookIssueRecord(userId, new Date(), null));
            bookServices.removeBook(isbn);
            System.out.println("Book issued successfully");
        }
        else{
            System.out.println("Book cannot be issued");
        }
    }

    public void returnBook(String isbn){
        BookIssueRecord record = issuanceServices.returnBook(isbn);
        if(record != null){
            record.setReturnDate(new Date());
            bookServices.addBook(new Book(isbn, "Title", "Author"));
            System.out.println("Book returned successfully");
        }else{
            System.out.println("Book was not issued");
        }

    }

    public void displayBooksByAuthor(String author){
        System.out.println("Books by " + author +":");
        bookServices.getBooksByAuthor(author).forEach(System.out::println);
    }
}
