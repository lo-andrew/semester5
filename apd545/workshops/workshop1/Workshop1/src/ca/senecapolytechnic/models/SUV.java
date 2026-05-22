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

public class SUV extends PassengerVehicles {
    public SUV(int currentMileage) {
        super("SUV", 45000.00, currentMileage);
        setServiceInterval(12000);
        setMaintenanceCost(450.00);
        setPrimaryFunction("Family transport, off-road capability");
        setFuelType("Hybrid");
    }
}
