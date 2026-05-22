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

package ca.senecapolytechnic.abstracts;

import ca.senecapolytechnic.interfaces.IVehicleMaintenance;
import ca.senecapolytechnic.interfaces.IVehicleOperations;

public abstract class Vehicle implements Comparable<Vehicle>, IVehicleOperations, IVehicleMaintenance {
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
        return name + " - $" + String.format("%,.1f", purchasePrice);
    }

    @Override
    public int compareTo(Vehicle other){
        int thisMilesRemaining = this.serviceInterval - this.currentMileage;
        int otherMilesRemaining = other.serviceInterval - other.currentMileage;
        return Integer.compare(thisMilesRemaining, otherMilesRemaining);
    }

    public String getName(){ return name; }

    public void setServiceInterval(int serviceInterval) {
        this.serviceInterval = serviceInterval;
    }

    public void setMaintenanceCost(double maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }

    public void setPrimaryFunction(String primaryFunction) {
        this.primaryFunction = primaryFunction;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getPrimaryFunction() {
        return primaryFunction;
    }

    public String getFuelType() {
        return fuelType;
    }

    public int getServiceInterval() {
        return serviceInterval;
    }

    public double getMaintenanceCost() {
        return maintenanceCost;
    }
}
