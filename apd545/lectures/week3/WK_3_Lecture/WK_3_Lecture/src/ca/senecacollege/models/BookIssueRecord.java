package ca.senecacollege.models;

import java.util.Date;

public class BookIssueRecord {
    private String userId;
    private Date issueDate;
    private Date returnDate;

    public BookIssueRecord(String userId, Date issueDate, Date returnDate) {
        this.userId = userId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "BookIssueRecord{" +
                "userId='" + userId + '\'' +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
