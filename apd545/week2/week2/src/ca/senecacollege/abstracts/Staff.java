package ca.senecacollege.abstracts;

import ca.senecacollege.interfaces.PersonActions;

public abstract class Staff extends Person{ //implements PersonActions {

    private String department;

    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void attendMeeting(){
        System.out.println(getName() + " is attending a "+department +" departmental meeting.");
    }

    @Override
    public String getDetails(){
        return "Department "+department;
    }
}
