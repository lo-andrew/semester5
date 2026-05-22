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

package ca.senecapolytechnic.controllers;

import ca.senecapolytechnic.abstracts.Vehicle;
import ca.senecapolytechnic.interfaces.IVehicleFilter;
import ca.senecapolytechnic.models.*;
import ca.senecapolytechnic.views.FleetView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FleetController {
    private ArrayList<Vehicle> fleet = new ArrayList<>();
    private FleetView view = new FleetView();

    private Scanner scanner = new Scanner(System.in);

    // requirement 1
    public int getValidMileage(String vehicleName) {
        int mileage = -1;
        boolean isValid = false;

        do {
            view.displayMileagePrompt(vehicleName);
            String input = scanner.nextLine();

            try { // get integer input
                mileage = Integer.parseInt(input);
                if (mileage < 0) {
                    view.displayNegativeMileageError();
                } else {
                    isValid = true;
                }
            } catch (NumberFormatException e) {
                view.displayInvalidMileageError();
            }
        } while (!isValid);

        return mileage;
    }

    // requirement 2
    public void findMostUrgentMaintenance(){
        Vehicle mostUrgent = fleet.get(0);
        for(Vehicle v : fleet){
            if(v.compareTo(mostUrgent) < 0){
                mostUrgent = v;
            }
        }
        view.displayMaintenanceResult(mostUrgent);
    }

    // requirement 3
    public void findPurchasePriceOrder(){
        fleet.sort((a, b) -> Double.compare(b.getPurchasePrice(), a.getPurchasePrice()));
        view.displayDescPriceFleet(fleet);
    }

    // requirement 4
    public void getVehiclesInCategory(){
        String vehicleCategory = getValidCategory();
        // lambda to get category equal to one from user
        IVehicleFilter filter = (v) -> v.getCategory().equals(vehicleCategory);

        ArrayList<Vehicle> filtered = new ArrayList<>();
        for (Vehicle v : fleet) {
            if (filter.match(v)) {
                filtered.add(v);
            }
        }
        view.displayCategoryResults(filtered, vehicleCategory);
    }

    private String getValidCategory() {
        String category;
        do {
            view.displayCategoryPrompt();
            category = scanner.nextLine().trim();
            if (!category.equals("PassengerVehicles") && !category.equals("CommercialVehicles") && !category.equals("SpecializedVehicles")) {
                view.displayInvalidCategoryError();
            }
        } while (!category.equals("PassengerVehicles") && !category.equals("CommercialVehicles") && !category.equals("SpecializedVehicles"));
        return category;
    }

    // requirement 5 and 6
    public void getVehicleMaintenanceUrgency(){
        Vehicle[] vehicleArray = fleet.toArray(new Vehicle[0]);
        Arrays.sort(vehicleArray, (a, b) -> a.compareTo(b));
        view.displayMaintenanceUrgency(vehicleArray);
    }

    public void start() {
        view.displayRequirement(1);
        fleet.add(new Sedan(getValidMileage("Sedan")));
        fleet.add(new SUV(getValidMileage("SUV")));
        fleet.add(new Truck(getValidMileage("Truck")));
        fleet.add(new Van(getValidMileage("Van")));
        fleet.add(new Ambulance(getValidMileage("Ambulance")));

        view.displayRequirement(2);
        findMostUrgentMaintenance();

        view.displayRequirement(3);
        findPurchasePriceOrder();

        view.displayRequirement(4);
        getVehiclesInCategory();

        view.displayRequirement(5);
        getVehicleMaintenanceUrgency();
    }
}