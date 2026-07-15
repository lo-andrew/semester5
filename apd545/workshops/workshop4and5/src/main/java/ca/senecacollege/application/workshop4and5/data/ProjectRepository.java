package ca.senecacollege.application.workshop4and5.data;

import ca.senecacollege.application.workshop4and5.models.Project;
import javafx.collections.ObservableList;

public class ProjectRepository {
    private ObservableList<Project> allProjects;

    public ObservableList<Project> findAll(){
        return allProjects;
    }
}
