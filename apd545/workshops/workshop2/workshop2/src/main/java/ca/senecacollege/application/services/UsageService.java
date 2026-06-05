package ca.senecacollege.application.services;

import ca.senecacollege.application.models.UsageLog;
import ca.senecacollege.application.models.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UsageService {
    private Map<Vehicle, List<UsageLog>> dataStore;

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
