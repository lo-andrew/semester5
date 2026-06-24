package ca.senecacollege.application.workshop3.controllers;

import ca.senecacollege.application.workshop3.enums.VehicleAge;
import ca.senecacollege.application.workshop3.enums.VehicleType;
import ca.senecacollege.application.workshop3.models.Vehicle;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class VehicleController {

    private RadioButton  rbCar;
    private RadioButton  rbTruck;
    private RadioButton  rbVan;
    private ToggleGroup  tgVehicleType;
    private Label        lblVehicleTypeError;
    private RadioButton  rbNew;
    private RadioButton  rbUsed;
    private ToggleGroup  tgVehicleAge;
    private TextField    txtVehiclePrice;
    private Label        lblPriceError;

    public void setFields(RadioButton rbCar, RadioButton rbTruck, RadioButton rbVan,
                          ToggleGroup tgVehicleType, Label lblVehicleTypeError,
                          RadioButton rbNew, RadioButton rbUsed, ToggleGroup tgVehicleAge,
                          TextField txtVehiclePrice, Label lblPriceError) {
        this.rbCar              = rbCar;
        this.rbTruck            = rbTruck;
        this.rbVan              = rbVan;
        this.tgVehicleType      = tgVehicleType;
        this.lblVehicleTypeError = lblVehicleTypeError;
        this.rbNew              = rbNew;
        this.rbUsed             = rbUsed;
        this.tgVehicleAge       = tgVehicleAge;
        this.txtVehiclePrice    = txtVehiclePrice;
        this.lblPriceError      = lblPriceError;
    }

    public boolean validateVehicle() {
        boolean valid = true;

        lblVehicleTypeError.setText("");
        lblPriceError.setText("");

        if (tgVehicleType.getSelectedToggle() == null) {
            lblVehicleTypeError.setText("Please select a vehicle type.");
            valid = false;
        }

        String priceText = txtVehiclePrice.getText().trim();
        if (priceText.isEmpty()) {
            lblPriceError.setText("Price is required.");
            valid = false;
        } else {
            try {
                double price = Double.parseDouble(priceText);
                if (price <= 0) {
                    lblPriceError.setText("Price must be greater than 0.");
                    valid = false;
                }
            } catch (NumberFormatException e) {
                lblPriceError.setText("Enter a valid number.");
                valid = false;
            }
        }

        return valid;
    }

    public Vehicle getVehicle() {
        Vehicle vehicle = new Vehicle();

        if (rbCar.isSelected())        vehicle.setType(VehicleType.CAR);
        else if (rbTruck.isSelected()) vehicle.setType(VehicleType.TRUCK);
        else if (rbVan.isSelected())   vehicle.setType(VehicleType.FAMILY_VAN);

        vehicle.setAge(rbNew.isSelected() ? VehicleAge.NEW : VehicleAge.USED);
        vehicle.setPrice(Double.parseDouble(txtVehiclePrice.getText().trim()));

        return vehicle;
    }

    public void clear() {
        rbCar.setSelected(true);
        rbNew.setSelected(true);
        txtVehiclePrice.clear();
        lblVehicleTypeError.setText("");
        lblPriceError.setText("");
    }
}
