package ca.senecacollege.services;

import ca.senecacollege.models.BookIssueRecord;

import java.util.HashMap;
import java.util.Map;

public class IssuanceServices {
    private Map<String, BookIssueRecord> issuedBooks;

    public IssuanceServices(){
        issuedBooks = new HashMap<>();
    }

    public void issueBook(String isbn, String userId, BookIssueRecord record){
        issuedBooks.put(isbn,record);
    }

    public BookIssueRecord returnBook(String isbn){
        return issuedBooks.remove(isbn);
    }

    public void displayIssuedBooks(Map<String, BookIssueRecord> bookrecords){
//        for(Map.Entry<String, BookIssueRecord> entry : bookrecords.entrySet()){
//            String isbn = entry.getKey();
//            BookIssueRecord record = entry.getValue();
//            System.out.println("Book: " + isbn + " issued to User: " + record.getUserId() +
//                    " Issue Date: " + record.getIssueDate() + ", Return Date: "+
//                    (record.getReturnDate() == null ? "Not Returned" : record.getReturnDate()));
//        }
        bookrecords.forEach((isbn,record)->{
            System.out.println("Book: " + isbn + " issued to User: " + record.getUserId() +
                    " Issue Date: " + record.getIssueDate() + ", Return Date: "+
                    (record.getReturnDate() == null ? "Not Returned" : record.getReturnDate()));
        });
    }

    public Map<String, BookIssueRecord> getIssuedBooks(){
        return issuedBooks;
    }
}
