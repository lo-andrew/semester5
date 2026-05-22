/***********************************************
 Workshop # 1
 Course: APD545 NBB - Semester 5
 Last Name: Lo
 First Name: Andrew
 ID: 162539217
 This assignment represents my own work in accordance
 with Seneca Academic Policy.
 Date: May 20th, 2026
 ***********************************************/

package ca.senecapolytechnic.abstracts;

public abstract class CommercialVehicles extends Vehicle {
    public CommercialVehicles(String name, double purchasePrice, int currentMileage) {
        super(name, purchasePrice, currentMileage);
    }

    @Override
    public String getCategory() {
        return "CommercialVehicles";
    }
}