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
