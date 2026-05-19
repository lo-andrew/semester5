package ca.senecapolytechnic.interfaces;

import ca.senecapolytechnic.abstracts.Vehicle;

@FunctionalInterface
public interface IVehicleFilter {
    public abstract boolean match(Vehicle v);

}
