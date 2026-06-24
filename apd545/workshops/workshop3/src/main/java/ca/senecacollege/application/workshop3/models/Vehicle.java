package ca.senecacollege.application.workshop3.models;

import ca.senecacollege.application.workshop3.enums.VehicleAge;
import ca.senecacollege.application.workshop3.enums.VehicleType;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;

public class Vehicle {
    private ObjectProperty<VehicleType> type;
    private ObjectProperty<VehicleAge> age;
    private DoubleProperty price;

    public VehicleType getType() {
        return type.get();
    }

    public ObjectProperty<VehicleType> typeProperty() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type.set(type);
    }

    public VehicleAge getAge() {
        return age.get();
    }

    public ObjectProperty<VehicleAge> ageProperty() {
        return age;
    }

    public void setAge(VehicleAge age) {
        this.age.set(age);
    }

    public double getPrice() {
        return price.get();
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }
}
