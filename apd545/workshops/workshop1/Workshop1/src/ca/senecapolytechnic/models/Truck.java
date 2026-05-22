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

package ca.senecapolytechnic.models;

import ca.senecapolytechnic.abstracts.CommercialVehicles;

public class Truck extends CommercialVehicles {
    public Truck(int currentMileage) {
        super("Truck", 62000.00, currentMileage);
        setServiceInterval(15000);
        setMaintenanceCost(600.00);
        setPrimaryFunction("Heavy cargo, long-distance hauling");
        setFuelType("Diesel");
    }
}
