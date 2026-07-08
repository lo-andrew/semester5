package ca.senecacollege.application.controllers;

import ca.senecacollege.application.repositories.ISceneRepository;
import ca.senecacollege.application.utility.SceneName;
import com.google.inject.Inject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ViewTwoController {
    private final Stage stage;
    private ISceneRepository sceneRepository;

    @Inject
    public ViewTwoController(Stage stage, ISceneRepository sceneRepository) {
        this.stage = stage;
        this.sceneRepository = sceneRepository;
    }

    @FXML
    void handleBack(ActionEvent event) {
        stage.setScene(sceneRepository.getScene(SceneName.MAIN));
    }

    @FXML
    void handleClose(ActionEvent event) {
        stage.close();
    }
}
