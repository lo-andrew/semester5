package ca.senecacollege.application.apd545project.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingSession {
    public int adults;
    public int children;
    public LocalDate checkIn;
    public LocalDate checkOut;
    public List<String> selectedRooms = new ArrayList<>();
    public String firstName;
    public String lastName;
    public String phone;
    public String email;
    public boolean wifiAddon;
    public boolean breakfastAddon;
    public boolean parkingAddon;
    public boolean spaAddon;
}
