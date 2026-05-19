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
