package ca.senecacollege.application.apd545project.app;

import ca.senecacollege.application.apd545project.controller.KioskController;
import ca.senecacollege.application.apd545project.util.ISceneRepository;
import ca.senecacollege.application.apd545project.util.InMemorySceneRepo;
import ca.senecacollege.application.apd545project.util.KioskStep;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class AppConfig {

    private final ISceneRepository sceneRepository;
    private final KioskController kioskController;

    public AppConfig(Stage stage) throws IOException {
        sceneRepository = new InMemorySceneRepo();
        kioskController = new KioskController(stage, sceneRepository);
        loadKioskViews();
    }

    private void loadKioskViews() throws IOException {
        Map<KioskStep, String> steps = Map.of(
            KioskStep.WELCOME,       "kiosk-step-welcome.fxml",
            KioskStep.OCCUPANCY,     "kiosk-step-occupancy.fxml",
            KioskStep.DATES,         "kiosk-step-dates.fxml",
            KioskStep.ROOMS,         "kiosk-step-rooms.fxml",
            KioskStep.GUEST_DETAILS, "kiosk-step-guest-details.fxml",
            KioskStep.ADDONS,        "kiosk-step-addons.fxml",
            KioskStep.SUMMARY,       "kiosk-step-summary.fxml",
            KioskStep.CONFIRMATION,  "kiosk-step-confirmation.fxml"
        );

        for (Map.Entry<KioskStep, String> entry : steps.entrySet()) {
            String path = "/ca/senecacollege/application/apd545project/view/" + entry.getValue();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            loader.setController(kioskController);
            Parent view = loader.load();
            sceneRepository.addView(entry.getKey(), view);
        }
    }

    public KioskController getKioskController() { return kioskController; }
    public ISceneRepository getSceneRepository() { return sceneRepository; }
}
