package ca.senecacollege.views;

public class SchoolView {

    public void displayDetails(String personType, String name, int age, String details) {

        System.out.println("Details of the :" + personType);
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.out.println(details);
        System.out.println();
    }
}
