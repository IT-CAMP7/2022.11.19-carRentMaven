package pl.camp.it.car.rent.database;

import pl.camp.it.car.rent.model.User;
import pl.camp.it.car.rent.model.Vehicle;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class VehicleDB2 implements IDB {
    @Override
    public List<User> getUsers() {
        throw new NotImplementedException();
    }

    @Override
    public User findUserByLogin(String login) {
        throw new NotImplementedException();
    }

    @Override
    public void persistToFile() {

    }

    @Override
    public boolean rentVehicle(String plate) {
        return false;
    }

    @Override
    public void addVehicle(Vehicle vehicle) {

    }

    @Override
    public List<Vehicle> getVehicles() {
        return null;
    }
}
