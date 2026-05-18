package ca.senecapolytechnic.abstracts;

public abstract class Vehicle implements Comparable<Vehicle> {
    private String name;
    private double purchasePrice;
    private int currentMileage;
    private int serviceInterval;
    private double maintenanceCost;
    private String primaryFunction;
    private String fuelType;

    public Vehicle(String name, double purchasePrice, int currentMileage){
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.currentMileage = currentMileage;
    }

    public abstract String getCategory();

    public int getCurrentMileage() {
        return currentMileage;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public String toString(){
        return name + " - $" + String.format("%.2f", purchasePrice);

    }

    @Override
    public int compareTo(Vehicle other){
        int thisMilesRemaining = this.serviceInterval - this.currentMileage;
        int otherMilesRemaining = other.serviceInterval - other.currentMileage;
        return Integer.compare(thisMilesRemaining, otherMilesRemaining);
    }



}
