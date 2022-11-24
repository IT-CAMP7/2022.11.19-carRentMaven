package pl.camp.it.car.rent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.camp.it.car.rent.database.IUserDB;
import pl.camp.it.car.rent.database.UserDB2;
import pl.camp.it.car.rent.gui.GUI;
import pl.camp.it.car.rent.model.User;

import java.io.IOException;

@Component
public class Authenticator {
    public static final String seed = "1Tl8*G3Ertpxvj0%8qpy";
    public static User loggedUser;
    @Autowired
    private GUI gui;
    @Autowired
    IUserDB userDB;
    //private static final Authenticator instance = new Authenticator();

    //private Authenticator() {}

    public boolean authenticate() throws IOException {
        for(int i = 0; i < 3; i++) {
            User user = gui.readLoginAndPassword();
            User userFromDB = userDB.findUserByLogin(user.getLogin());
            if(userFromDB != null && userFromDB.equals(user)) {
                Authenticator.loggedUser = userFromDB;
                return true;
            }
        }
        return false;
    }

    /*public static Authenticator getInstance() {
        return instance;
    }*/
}
