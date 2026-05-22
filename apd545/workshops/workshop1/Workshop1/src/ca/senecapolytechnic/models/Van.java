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

public class Van extends CommercialVehicles {
    public Van(int currentMileage) {
        super("Van", 38500.00, currentMileage);
        setServiceInterval(10000);
        setMaintenanceCost(400.00);
        setPrimaryFunction("Passenger group transport, deliveries");
        setFuelType("Gasoline");
    }
}
