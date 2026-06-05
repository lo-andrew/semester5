package ca.senecacollege.application.services;

import ca.senecacollege.application.models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleService {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle v){
        vehicles.add(v);
    }

    public List<Vehicle> getAllVehicles(){
        return vehicles;
    }
}
