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
