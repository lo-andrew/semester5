package ca.senecacollege.application.apd545project.controller;

import ca.senecacollege.application.apd545project.model.BookingSession;
import ca.senecacollege.application.apd545project.model.RoomSelectionRow;
import ca.senecacollege.application.apd545project.util.ISceneRepository;
import ca.senecacollege.application.apd545project.util.KioskStep;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    @FXML private Label suggestionLabel;
    @FXML private TableView<RoomSelectionRow> customRoomsTable;
    @FXML private TableColumn<RoomSelectionRow, String> customRoomTypeColumn;
    @FXML private TableColumn<RoomSelectionRow, Number> customQuantityColumn;
    @FXML private TableColumn<RoomSelectionRow, Number> customPriceColumn;
    @FXML private TableView<RoomSelectionRow> addedRoomsTable;
    @FXML private TableColumn<RoomSelectionRow, String> addedRoomTypeColumn;
    @FXML private TableColumn<RoomSelectionRow, Number> addedQuantityColumn;
    @FXML private TableColumn<RoomSelectionRow, Number> addedPriceColumn;
    @FXML private Label customSelectionSummaryLabel;

    // guest
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField phoneField;
    @FXML private TextField emailField;
    @FXML private Label firstNameError;
    @FXML private Label lastNameError;
    @FXML private Label phoneError;
    @FXML private Label emailError;
    @FXML private TextField addressField;
    @FXML private TextField postalCodeField;
    @FXML private Label addressError;
    @FXML private Label postalCodeError;
    @FXML private RadioButton loyaltyOptInRadio;
    @FXML private Label loyaltyStatusLabel;

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
    @FXML private Label seasonalDiscountLabel;
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

    // staff login on side
    @FXML protected void onStaffLogin() { }

    // leave feedback on side
    @FXML protected void onLeaveFeedback() { }
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
    @FXML protected void onRoomsNext() { navigate(KioskStep.ADDONS); }
    @FXML protected void onRoomsBack() { navigate(KioskStep.DATES); }

    // placeholder data for the "choose my own" table until real room/pricing data is wired up
    public void populateRoomsPlaceholders() {
        customRoomTypeColumn.setCellValueFactory(data ->
            new SimpleStringProperty(data.getValue().roomType));
        customQuantityColumn.setCellValueFactory(data ->
            new SimpleIntegerProperty(data.getValue().quantity));
        customPriceColumn.setCellValueFactory(data ->
            new SimpleDoubleProperty(data.getValue().pricePerNight));

        // "Available" here is placeholder inventory data, not the guest's desired quantity
        customRoomsTable.getItems().setAll(
            new RoomSelectionRow("Single", 5, 99.99),
            new RoomSelectionRow("Double", 3, 149.99),
            new RoomSelectionRow("Penthouse", 2, 349.99)
        );

        addedRoomTypeColumn.setCellValueFactory(data ->
            new SimpleStringProperty(data.getValue().roomType));
        addedQuantityColumn.setCellValueFactory(data ->
            new SimpleIntegerProperty(data.getValue().quantity));
        addedPriceColumn.setCellValueFactory(data ->
            new SimpleDoubleProperty(data.getValue().pricePerNight));
    }

    private static int occupancyPerRoom(String roomType) {
        return switch (roomType) {
            case "Double" -> 4;
            default -> 2; // Single, Deluxe, Penthouse
        };
    }

    private void updateSelectionSummary() {
        int totalRooms = 0;
        int totalOccupancy = 0;
        for (RoomSelectionRow row : addedRoomsTable.getItems()) {
            totalRooms += row.quantity;
            totalOccupancy += row.quantity * occupancyPerRoom(row.roomType);
        }
        customSelectionSummaryLabel.setText(
            "Selected: " + totalRooms + " rooms, " + totalOccupancy + " total occupancy");
    }

    @FXML
    protected void onAddSelectedRoom() {
        RoomSelectionRow selected = customRoomsTable.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        for (RoomSelectionRow row : addedRoomsTable.getItems()) {
            if (row.roomType.equals(selected.roomType)) {
                row.quantity++;
                addedRoomsTable.refresh();
                updateSelectionSummary();
                return;
            }
        }
        addedRoomsTable.getItems().add(new RoomSelectionRow(selected.roomType, 1, selected.pricePerNight));
        updateSelectionSummary();
    }

    @FXML
    protected void onRemoveSelectedRoom() {
        RoomSelectionRow selected = addedRoomsTable.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        if (selected.quantity > 1) {
            selected.quantity--;
            addedRoomsTable.refresh();
        } else {
            addedRoomsTable.getItems().remove(selected);
        }
        updateSelectionSummary();
    }

    @FXML
    protected void onSuggestedModeSelected() {
        suggestedPanel.setVisible(true);
        suggestedPanel.setManaged(true);
        customPanel.setVisible(false);
        customPanel.setManaged(false);
    }

    @FXML
    protected void onCustomModeSelected() {
        suggestedPanel.setVisible(false);
        suggestedPanel.setManaged(false);
        customPanel.setVisible(true);
        customPanel.setManaged(true);
    }

    // 5. add-ons
    @FXML protected void onAddonToggled() { }
    @FXML protected void onAddonsNext() { navigate(KioskStep.GUEST_DETAILS); }
    @FXML protected void onAddonsBack() { navigate(KioskStep.ROOMS); }

    // 6. guest
    @FXML protected void onGuestDetailsNext() { navigate(KioskStep.SUMMARY); }
    @FXML protected void onGuestDetailsBack() { navigate(KioskStep.ADDONS); }
    @FXML protected void onLoyaltyOptInToggled() { }

    // 7. summary
    @FXML protected void onConfirm() { navigate(KioskStep.CONFIRMATION); }
    @FXML protected void onSummaryBack() { navigate(KioskStep.GUEST_DETAILS); }

    // 8. confirmation
    @FXML protected void onStartOver() { navigate(KioskStep.WELCOME); }
}
