package ca.senecacollege.application.apd545project.util;

import javafx.scene.Parent;

import java.util.HashMap;
import java.util.Map;

public class InMemorySceneRepo implements ISceneRepository {

    private final Map<KioskStep, Parent> viewMap = new HashMap<>();

    @Override
    public Parent getView(KioskStep step) {
        return viewMap.get(step);
    }

    @Override
    public void addView(KioskStep step, Parent view) {
        viewMap.put(step, view);
    }
}
