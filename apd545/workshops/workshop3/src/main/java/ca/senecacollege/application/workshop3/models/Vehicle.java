package ca.senecacollege.application.workshop3.models;

import ca.senecacollege.application.workshop3.enums.VehicleAge;
import ca.senecacollege.application.workshop3.enums.VehicleType;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Vehicle {
    private ObjectProperty<VehicleType> type  = new SimpleObjectProperty<>();
    private ObjectProperty<VehicleAge>  age   = new SimpleObjectProperty<>();
    private DoubleProperty              price = new SimpleDoubleProperty();

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
