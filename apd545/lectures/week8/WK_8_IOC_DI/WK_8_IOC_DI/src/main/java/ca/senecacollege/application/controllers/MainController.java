package ca.senecacollege.application.controllers;

import ca.senecacollege.application.repositories.ISceneRepository;
import ca.senecacollege.application.utility.SceneName;
import com.google.inject.Inject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class MainController {

    private final Stage stage;
    private ISceneRepository sceneRepository;

    @Inject
    public MainController(Stage stage, ISceneRepository sceneRepository) {
        this.stage = stage;
        this.sceneRepository = sceneRepository;
    }

    @FXML
    void handleClose(ActionEvent event) {
        stage.close();
    }

    @FXML
    void handleOnPressBtn1(ActionEvent event) {
            stage.setScene(sceneRepository.getScene(SceneName.SCENE1));
    }

    @FXML
    void handleOnPressBtn2(ActionEvent event) {
        stage.setScene(sceneRepository.getScene(SceneName.SCENE2));
    }

    @FXML
    void handleOnPressBtn3(ActionEvent event) {
        stage.setScene(sceneRepository.getScene(SceneName.SCENE3));
    }

}
