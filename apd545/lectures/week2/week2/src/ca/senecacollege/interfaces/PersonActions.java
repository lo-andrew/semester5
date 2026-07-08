package ca.senecacollege.interfaces;

import ca.senecacollege.abstracts.Person;

@FunctionalInterface
public interface PersonActions {
    void performRole(Person person);
}
