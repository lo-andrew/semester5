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