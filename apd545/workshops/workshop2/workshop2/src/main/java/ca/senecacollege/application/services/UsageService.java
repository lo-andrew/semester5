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

import ca.senecacollege.application.models.UsageLog;
import ca.senecacollege.application.models.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsageService {
    private Map<Vehicle, List<UsageLog>> dataStore = new HashMap<>();

    public void addLog(Vehicle v, UsageLog log){
        if(!dataStore.containsKey(v)){
            dataStore.put(v, new ArrayList<>());
        }
        dataStore.get(v).add(log);
    }

    public List<UsageLog> getLogs(Vehicle v){
        return dataStore.get(v);
    }
}
