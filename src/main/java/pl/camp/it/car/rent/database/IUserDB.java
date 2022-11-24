package pl.camp.it.car.rent.database;

import pl.camp.it.car.rent.model.User;

import java.util.List;

public interface IUserDB {
    List<User> getUsers();
    User findUserByLogin(String login);
    void persistToFile();
}
