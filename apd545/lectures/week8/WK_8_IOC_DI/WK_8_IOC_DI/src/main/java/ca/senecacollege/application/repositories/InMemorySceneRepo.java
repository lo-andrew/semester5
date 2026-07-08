package ca.senecacollege.application.repositories;

import ca.senecacollege.application.utility.SceneName;
import javafx.scene.Scene;

import java.util.HashMap;
import java.util.Map;

public class InMemorySceneRepo implements ISceneRepository {

    private final Map<SceneName, Scene> sceneMap = new HashMap<>();

    @Override
    public Scene getScene(SceneName sceneName) {
        return sceneMap.get(sceneName);
    }

    @Override
    public void addScene(SceneName sceneName, Scene scene) {
        sceneMap.put(sceneName, scene);
    }
}
