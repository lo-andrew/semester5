package ca.senecacollege.application.repositories;

import ca.senecacollege.application.utility.SceneName;
import javafx.scene.Scene;

public interface ISceneRepository {
    Scene getScene(SceneName sceneName);
    void addScene(SceneName sceneName, Scene scene);
}
