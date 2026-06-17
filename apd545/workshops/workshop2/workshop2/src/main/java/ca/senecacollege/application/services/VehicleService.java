/**********************************************
 Workshop #2
 Course: APD545 - Semester 5
 Last Name: Lo
 First Name: Andrew
 ID: 162539217
 Section:NBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Andrew Lo
 Date: June 6th, 2026
 **********************************************/

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
