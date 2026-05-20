package ca.senecacollege.views;

import ca.senecacollege.controllers.LibraryController;

public class MainView {
    static void main() {

        LibraryController libraryController = new LibraryController();

        //Add a book to the library
        libraryController.addBook("1234567890","Effective java", "Joshua Bloch");
        libraryController.addBook("0987654321","Clean Code", "Robert C. Martin");

        //Add Users
        libraryController.addUser("u001", "Alice");
        libraryController.addUser("u002", "Frank");

        //Display Books
        System.out.println("Books in the Library");
        libraryController.displayBooks();

        //Display Users
        System.out.println("Users in the Library");
        libraryController.displayUsers();

        //Issue a book
        System.out.println("Issuing book '1234567890' to user 'u001'");
        libraryController.issueBook("1234567890","u001");

        //Display Books
        System.out.println("Books in the Library");
        libraryController.displayBooks();

        //Return Book
        System.out.println("Returning book '1234567890'");
        libraryController.returnBook("1234567890");

        //Display Books
        System.out.println("Books in the Library");
        libraryController.displayBooks();

    }
}
