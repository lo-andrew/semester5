package ca.senecapolytechnic.controllers;

import ca.senecapolytechnic.abstracts.Vehicle;
import ca.senecapolytechnic.interfaces.IVehicleFilter;
import ca.senecapolytechnic.models.*;
import ca.senecapolytechnic.views.FleetView;
import java.util.ArrayList;
import java.util.Arrays;

public class FleetController {
    private ArrayList<Vehicle> fleet = new ArrayList<>();
    private FleetView view = new FleetView();

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
        String vehicleCategory = view.getVehicleCategory();
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

    public void start() {
        System.out.println("--: Requirement 1 :--");
        fleet.add(new Sedan(view.getMileageInput("Sedan")));
        fleet.add(new SUV(view.getMileageInput("SUV")));
        fleet.add(new Truck(view.getMileageInput("Truck")));
        fleet.add(new Van(view.getMileageInput("Van")));
        fleet.add(new Ambulance(view.getMileageInput("Ambulance")));

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