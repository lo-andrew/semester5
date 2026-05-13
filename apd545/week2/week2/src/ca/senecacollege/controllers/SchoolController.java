package ca.senecacollege.controllers;

import ca.senecacollege.abstracts.Person;
import ca.senecacollege.interfaces.PersonActions;
import ca.senecacollege.models.Student;
import ca.senecacollege.views.SchoolView;

public class SchoolController {

    SchoolView schoolView;

    public SchoolController(SchoolView schoolView) {
        this.schoolView = schoolView;
    }

    //schoolView.displayDetail(students, "",65,)
    public void displayPersonDetails(Person person) {
       /* if(person instanceof Student){
            schoolView.displayDetails("Student", person.getName(),
                    person.getAge(), person.getDetails());
        }
        if(person instanceof Teacher)*/
        schoolView.displayDetails(person.getClass().getSimpleName(), person.getName(),
                person.getAge(), person.getDetails());
    }

    public void performPeronRole(Person person,PersonActions personActions) {
        personActions.performRole(person);
    }
}
