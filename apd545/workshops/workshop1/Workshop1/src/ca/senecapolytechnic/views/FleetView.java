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

package ca.senecapolytechnic.views;

import ca.senecapolytechnic.abstracts.Vehicle;

import java.util.ArrayList;


public class FleetView {
    public void displayMileagePrompt(String vehicleName) {
        System.out.print("Enter the current mileage for " + vehicleName + " (km): ");
    }

    public void displayCategoryPrompt() {
        System.out.print("Enter a vehicle category (PassengerVehicles, CommercialVehicles, SpecializedVehicles): ");
    }


    public void displayMaintenanceResult(Vehicle v){
        System.out.println("The vehicle requiring the most urgent maintenance is: " + v.getName());
        System.out.println(v.getName() + "'s purchase price is: $" + String.format("%,.1f", v.getPurchasePrice()));
        System.out.println(v.getName() + "'s primary function: " + v.getPrimaryFunction());
        System.out.println(v.getName() + "'s service interval: Every " + String.format("%,d", v.getServiceInterval()) + " km");
        System.out.println(v.getName() + "'s maintenance cost: $" +  String.format("%,.1f", v.getMaintenanceCost()));
    }

    public void displayDescPriceFleet(ArrayList<Vehicle> fleet){
        System.out.println("Vehicles in Descending Order of Purchase Price:");
        fleet.forEach(v -> {
            System.out.println(v.toString());
        });
    }

    public void displayCategoryResults (ArrayList<Vehicle> filtered, String category){
        System.out.println("Vehicles in " + category + " Category:");
        filtered.forEach(v -> {
            System.out.println(v.getName() + " - Primary Function: " + v.getPrimaryFunction() + " - Fuel Type: " + v.getFuelType());
        });
    }

    public void displayMaintenanceUrgency(Vehicle[] vehicles) {
        System.out.println("Vehicles sorted by maintenance urgency (closest to service interval first):");
        for (Vehicle v : vehicles) {
            int remaining = v.getServiceInterval() - v.getCurrentMileage();
            System.out.printf("%s (%,d km / %,d km - %,d km remaining)%n",
                    v.getName(),
                    v.getCurrentMileage(),
                    v.getServiceInterval(),
                    remaining);
        }
    }

    public void displayInvalidMileageError() {
        System.out.println("Invalid input. Please enter a positive integer.");
    }

    public void displayNegativeMileageError() {
        System.out.println("Mileage cannot be negative or zero. Please try again.");
    }

    public void displayInvalidCategoryError() {
        System.out.println("Invalid category. Please enter one of: PassengerVehicles, CommercialVehicles, SpecializedVehicles.");
    }

    public void displayRequirement(int req) {
        if (req == 5){
            System.out.println("\n--: Requirement " + req + " & 6 :--");

        } else {
            System.out.println("\n--: Requirement " + req + " :--");
        }
    }

}