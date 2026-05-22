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

package ca.senecapolytechnic.interfaces;

import ca.senecapolytechnic.abstracts.Vehicle;

@FunctionalInterface
public interface IVehicleFilter {
    public abstract boolean match(Vehicle v);
}
