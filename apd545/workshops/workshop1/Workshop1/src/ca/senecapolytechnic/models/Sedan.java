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

import ca.senecapolytechnic.abstracts.PassengerVehicles;

public class Sedan extends PassengerVehicles {
    public Sedan(int currentMileage) {
        super("Sedan", 28500.00, currentMileage);
        setServiceInterval(10000);
        setMaintenanceCost(350.00);
        setPrimaryFunction("Executive transportation, client visits");
        setFuelType("Gasoline");
    }
}
