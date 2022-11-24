package pl.camp.it.car.rent.database;

import pl.camp.it.car.rent.model.Vehicle;

import java.util.List;

public interface IVehicleDB {
    boolean rentVehicle(String plate);
    void addVehicle(Vehicle vehicle);
    List<Vehicle> getVehicles();
    void persistToFile();
}
