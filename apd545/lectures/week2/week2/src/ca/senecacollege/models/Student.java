package ca.senecacollege.models;

import ca.senecacollege.abstracts.Person;
import ca.senecacollege.interfaces.PersonActions;

public class Student extends Person{ //implements PersonActions {

    private String stundetID;

    public Student(String name, int age, String stundetID){
        super(name, age);
        this.stundetID = stundetID;
    }

    @Override
    public String getDetails() {
        return "Student Id: " + this.stundetID;
    }

//    @Override
//    public void performRole() {
//        System.out.println(getName() + " is studying.");
//    }
}
