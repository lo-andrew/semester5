package ca.senecacollege.models;

import ca.senecacollege.abstracts.Staff;

public class Teacher extends Staff {

    private String subject;

    public Teacher(String name, int age, String department, String subject) {
        super(name, age, department);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String getDetails(){
        return super.getDetails() + " Subject: " + subject;
    }

//    @Override
//    public void performRole() {
//        System.out.println(getName() + " is teaching " + subject +".");
//    }
}
