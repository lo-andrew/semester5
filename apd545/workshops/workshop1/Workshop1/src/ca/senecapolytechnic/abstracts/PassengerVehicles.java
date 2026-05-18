package ca.senecapolytechnic.abstracts;

public abstract class PassengerVehicles extends Vehicle {

    public PassengerVehicles(String name, double purchasePrice, int currentMileage) {
        super(name, purchasePrice, currentMileage);
    }

    @Override
    public String getCategory(){
        return "PassengerVehicles";
    }
}
