package pl.camp.it.car.rent.database;

import pl.camp.it.car.rent.model.User;
import pl.camp.it.car.rent.model.Vehicle;

import java.util.List;

public interface IDB {
    List<User> getUsers();
    User findUserByLogin(String login);
    void persistToFile();
    boolean rentVehicle(String plate);
    void addVehicle(Vehicle vehicle);
    List<Vehicle> getVehicles();
}
