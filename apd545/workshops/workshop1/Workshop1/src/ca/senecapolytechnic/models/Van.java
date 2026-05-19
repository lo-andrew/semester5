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
