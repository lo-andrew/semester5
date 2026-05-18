package ca.senecapolytechnic.abstracts;

public abstract class SpecializedVehicles extends Vehicle {
    public SpecializedVehicles(String name, double purchasePrice, int currentMileage) {
        super(name, purchasePrice, currentMileage);
    }

    @Override
    public String getCategory() {
        return "SpecializedVehicles";
    }
}