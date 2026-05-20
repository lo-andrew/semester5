package ca.senecacollege.services;

import ca.senecacollege.models.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookServices {
    private Map<String, Book> books;

    public BookServices() {
        books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }
    public Book getBook(String isbn) {
        return books.get(isbn);
    }

    public void displayBooks(){
        //Imperative Style programming
//        for(Book book : books.values()){
//            System.out.println(book);
//        }

        //Declarative Style: What you want? using Stream API
        books.values().stream().forEach(System.out::println);
    }

    public void removeBook(String isbn){
        books.remove(isbn);
    }

    public List<Book> getBooksByAuthor(String author){

        return books.values().stream()
                .filter(book->book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());

    }
}
