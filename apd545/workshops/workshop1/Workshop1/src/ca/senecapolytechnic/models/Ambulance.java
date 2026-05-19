package ca.senecapolytechnic.models;

import ca.senecapolytechnic.abstracts.SpecializedVehicles;

public class Ambulance extends SpecializedVehicles {
    public Ambulance(int currentMileage) {
        super("Ambulance", 85000.00, currentMileage);
        setServiceInterval(8000);
        setMaintenanceCost(800.00);
        setPrimaryFunction("Emergency medical transport, life-saving");
        setFuelType("Diesel");
    }
}
