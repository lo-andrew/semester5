package ca.senecacollege.application.apd545project.controller;

import ca.senecacollege.application.apd545project.model.BookingSession;
import ca.senecacollege.application.apd545project.util.ISceneRepository;
import ca.senecacollege.application.apd545project.util.KioskStep;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class KioskController {

    private final Stage stage;
    private final ISceneRepository sceneRepository;
    private final BookingSession session = new BookingSession();

    public KioskController(Stage stage, ISceneRepository sceneRepository) {
        this.stage = stage;
        this.sceneRepository = sceneRepository;
    }

    // shell
    @FXML private BorderPane root;

    // occupancy
    @FXML private Spinner<Integer> adultsSpinner;
    @FXML private Spinner<Integer> childrenSpinner;

    // dates
    @FXML private DatePicker checkInPicker;
    @FXML private DatePicker checkOutPicker;
    @FXML private Label nightsLabel;

    // rooms
    @FXML private RadioButton suggestedRadio;
    @FXML private RadioButton customRadio;
    @FXML private VBox suggestedPanel;
    @FXML private VBox customPanel;
    @FXML private ListView<String> suggestedRoomsList;
    @FXML private ListView<String> availableRoomsList;
    @FXML private Label suggestionLabel;

    // guest
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField phoneField;
    @FXML private TextField emailField;
    @FXML private Label firstNameError;
    @FXML private Label lastNameError;
    @FXML private Label phoneError;
    @FXML private Label emailError;

    // addons
    @FXML private CheckBox wifiCheck;
    @FXML private CheckBox breakfastCheck;
    @FXML private CheckBox parkingCheck;
    @FXML private CheckBox spaCheck;
    @FXML private Label addonsTotalLabel;

    // summary
    @FXML private Label guestNameLabel;
    @FXML private Label datesLabel;
    @FXML private Label roomsLabel;
    @FXML private Label addonsLabel;
    @FXML private Label subtotalLabel;
    @FXML private Label taxLabel;
    @FXML private Label loyaltyLabel;
    @FXML private Label totalLabel;

    // confirmation
    @FXML private Label confirmationRefLabel;

    // error label shared
    @FXML private Label errorLabel;

    private void navigate(KioskStep step) {
        root.setCenter(sceneRepository.getView(step));
    }
    // rules on side
    @FXML protected void onViewRules() { }
    public void showInitialView() { navigate(KioskStep.WELCOME); }

    // 1. welcome
    @FXML protected void onWelcomeNext() { navigate(KioskStep.OCCUPANCY); }

    // 2. occupancy
    @FXML protected void onOccupancyNext() { navigate(KioskStep.DATES); }
    @FXML protected void onOccupancyBack() { navigate(KioskStep.WELCOME); }

    // 3. dates
    @FXML protected void onDatesNext() { navigate(KioskStep.ROOMS); }
    @FXML protected void onDatesBack() { navigate(KioskStep.OCCUPANCY); }

    // 4. rooms
    @FXML protected void onRoomsNext() { navigate(KioskStep.GUEST_DETAILS); }
    @FXML protected void onRoomsBack() { navigate(KioskStep.DATES); }

    // 5. guest
    @FXML protected void onGuestDetailsNext() { navigate(KioskStep.ADDONS); }
    @FXML protected void onGuestDetailsBack() { navigate(KioskStep.ROOMS); }

    // 6. add-ons
    @FXML protected void onAddonToggled() { }
    @FXML protected void onAddonsNext() { navigate(KioskStep.SUMMARY); }
    @FXML protected void onAddonsBack() { navigate(KioskStep.GUEST_DETAILS); }

    // 7. summary
    @FXML protected void onConfirm() { navigate(KioskStep.CONFIRMATION); }
    @FXML protected void onSummaryBack() { navigate(KioskStep.ADDONS); }

    // 8. confirmation
    @FXML protected void onStartOver() { navigate(KioskStep.WELCOME); }
}
