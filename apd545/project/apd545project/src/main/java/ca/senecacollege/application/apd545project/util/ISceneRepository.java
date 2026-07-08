package ca.senecacollege.application.apd545project.util;

import javafx.scene.Parent;

public interface ISceneRepository {
    Parent getView(KioskStep step);
    void addView(KioskStep step, Parent view);
}
