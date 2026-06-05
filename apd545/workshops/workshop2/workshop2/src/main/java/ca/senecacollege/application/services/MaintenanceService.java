package ca.senecacollege.application.services;

import ca.senecacollege.application.models.MaintenanceRecord;
import ca.senecacollege.application.models.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MaintenanceService {
    private Map<Vehicle, List<MaintenanceRecord>> dataStore;

    public void addRecord(Vehicle v, MaintenanceRecord r){
        if (!dataStore.containsKey(v)) {
            dataStore.put(v, new ArrayList<>());
        }
        dataStore.get(v).add(r);
    }

    public List<MaintenanceRecord> getRecords(Vehicle v){
        return dataStore.get(v);

    }
}
