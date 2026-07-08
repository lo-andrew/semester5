package ca.senecacollege.tester;

import ca.senecacollege.controllers.SchoolController;
import ca.senecacollege.interfaces.PersonActions;
import ca.senecacollege.models.Student;
import ca.senecacollege.models.Teacher;
import ca.senecacollege.views.SchoolView;

public class TestSchool {
    static void main() {
        SchoolView view = new SchoolView();

        //Controller
        SchoolController controller = new SchoolController(view);

        //Model Instances
        Student student = new Student("Frank", 18,"s1234");
        Teacher teacher = new Teacher("John", 35,"Mathematics","Calculus-1");

        //Display Details from the view
        controller.displayPersonDetails(student);
        controller.displayPersonDetails(teacher);

        //Lambda definition
        PersonActions studentRole = (p)->System.out.println(p.getName()+" is studying.");
        PersonActions teacherRole = (p)->{
            Teacher t = (Teacher)p;
            System.out.println(t.getName() + " is teaching " + t.getSubject() + ".");
        };

        //PerformROle
        controller.performPeronRole(student, studentRole);
        controller.performPeronRole(teacher, teacherRole);
    }
}
