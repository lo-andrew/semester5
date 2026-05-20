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


    public void findMostUrgentMaintenance(){
        Vehicle mostUrgent = fleet.get(0);
        for(Vehicle v : fleet){
            if(v.compareTo(mostUrgent) < 0){
                mostUrgent = v;
            }
        }
        view.displayMaintenanceResult(mostUrgent);
    }

    public void findPurchasePriceOrder(){
        fleet.sort((a, b) -> Double.compare(b.getPurchasePrice(), a.getPurchasePrice()));
        view.displayDescPriceFleet(fleet);
    }

    public void getVehiclesInCategory(){
        String vehicleCategory = getValidCategory();
        IVehicleFilter filter = (v) -> v.getCategory().equals(vehicleCategory);

        ArrayList<Vehicle> filtered = new ArrayList<>();
        for (Vehicle v : fleet) {
            if (filter.match(v)) {
                filtered.add(v);
            }
        }
        view.displayCategoryResults(filtered, vehicleCategory);
    }

    public void getVehicleMaintenanceUrgency(){
        Vehicle[] vehicleArray = fleet.toArray(new Vehicle[0]);
        Arrays.sort(vehicleArray, (a, b) -> a.compareTo(b));
        view.displayMaintenanceUrgency(vehicleArray);
    }

    private int getValidMileage(String vehicleName) {
        int mileage;
        do {
            view.displayMileagePrompt(vehicleName);
            String input = scanner.nextLine();
            while (!input.matches("\\d+")) {
                view.displayError("Invalid input. Please enter a positive integer.");
                view.displayMileagePrompt(vehicleName);
                input = scanner.nextLine();
            }
            mileage = Integer.parseInt(input);
            if (mileage <= 0) {
                view.displayError("Mileage cannot be negative or zero. Please try again.");
            }
        } while (mileage <= 0);
        return mileage;
    }

    private String getValidCategory() {
        String category;
        do {
            view.displayCategoryPrompt();
            category = scanner.nextLine().trim();
            if (!category.equals("PassengerVehicles") && !category.equals("CommercialVehicles") && !category.equals("SpecializedVehicles")) {
                view.displayError("Invalid category. Please enter one of: PassengerVehicles, CommercialVehicles, SpecializedVehicles.");
            }
        } while (!category.equals("PassengerVehicles") && !category.equals("CommercialVehicles") && !category.equals("SpecializedVehicles"));
        return category;
    }

    public void start() {
        System.out.println("--: Requirement 1 :--");
        fleet.add(new Sedan(getValidMileage("Sedan")));
        fleet.add(new SUV(getValidMileage("SUV")));
        fleet.add(new Truck(getValidMileage("Truck")));
        fleet.add(new Van(getValidMileage("Van")));
        fleet.add(new Ambulance(getValidMileage("Ambulance")));

        System.out.println("\n--: Requirement 2 :--");
        findMostUrgentMaintenance();

        System.out.println("\n--: Requirement 3 :--\n");
        findPurchasePriceOrder();

        System.out.println("\n--: Requirement 4 :--");
        getVehiclesInCategory();

        System.out.println("\n--: Requirement 5 & 6 :--");
        getVehicleMaintenanceUrgency();
    }
}