/**********************************************
 Workshop # 3
 Course:APD545 - Semester 5
 Last Name: Lo
 First Name: Andrew
 ID: 162539217
 Section: NBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: June 26th, 2026
 **********************************************/

package ca.senecacollege.application.workshop3.controllers;

import ca.senecacollege.application.workshop3.models.Customer;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CustomerController {

    private TextField txtName;
    private TextField txtPhone;
    private TextField txtCity;
    private ComboBox<String> cmbProvince;
    private Label lblNameError;
    private Label lblPhoneError;
    private Label lblCityError;
    private Label lblProvinceError;

    public void setFields(TextField txtName, TextField txtPhone, TextField txtCity,
                          ComboBox<String> cmbProvince, Label lblNameError,
                          Label lblPhoneError, Label lblCityError, Label lblProvinceError) {
        this.txtName = txtName;
        this.txtPhone = txtPhone;
        this.txtCity = txtCity;
        this.cmbProvince = cmbProvince;
        this.lblNameError = lblNameError;
        this.lblPhoneError = lblPhoneError;
        this.lblCityError = lblCityError;
        this.lblProvinceError = lblProvinceError;

        cmbProvince.getItems().addAll(
            "AB", "BC", "MB", "NB", "NL", "NS", "NT", "NU", "ON", "PE", "QC", "SK", "YT"
        );
    }

    public boolean validateCustomer() {
        boolean valid = true;

        lblNameError.setText("");
        lblPhoneError.setText("");
        lblCityError.setText("");
        lblProvinceError.setText("");

        if (txtName.getText().trim().isEmpty()) {
            lblNameError.setText("Name is required.");
            valid = false;
        }

        String phone = txtPhone.getText().trim();
        if (phone.isEmpty()) {
            lblPhoneError.setText("Phone is required.");
            valid = false;
        } else if (!phone.matches("\\d{3}-\\d{3}-\\d{4}")) {
            lblPhoneError.setText("Format: 123-456-7890");
            valid = false;
        }

        if (txtCity.getText().trim().isEmpty()) {
            lblCityError.setText("City is required.");
            valid = false;
        }

        if (cmbProvince.getValue() == null) {
            lblProvinceError.setText("Province is required.");
            valid = false;
        }

        return valid;
    }

    public Customer getCustomer() {
        Customer customer = new Customer();
        customer.setName(txtName.getText().trim());
        customer.setPhone(txtPhone.getText().trim());
        customer.setCity(txtCity.getText().trim());
        customer.setProvince(cmbProvince.getValue());
        return customer;
    }

    public void clear() {
        txtName.clear();
        txtPhone.clear();
        txtCity.clear();
        cmbProvince.setValue(null);
        lblNameError.setText("");
        lblPhoneError.setText("");
        lblCityError.setText("");
        lblProvinceError.setText("");
    }
}
