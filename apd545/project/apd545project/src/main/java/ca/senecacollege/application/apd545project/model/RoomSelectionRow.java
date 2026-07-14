package ca.senecacollege.application.apd545project.model;

// placeholder row for the "choose my own room type" table on the kiosk rooms step

public class RoomSelectionRow {
    public String roomType;
    public int quantity;
    public double pricePerNight;

    public RoomSelectionRow(String roomType, int quantity, double pricePerNight) {
        this.roomType = roomType;
        this.quantity = quantity;
        this.pricePerNight = pricePerNight;
    }
}
