package pl.camp.it.car.rent.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.camp.it.car.rent.Authenticator;
import pl.camp.it.car.rent.database.IUserDB;
import pl.camp.it.car.rent.database.IVehicleDB;
import pl.camp.it.car.rent.database.UserDB2;
import pl.camp.it.car.rent.database.VehicleDB;
import pl.camp.it.car.rent.gui.GUI;
import pl.camp.it.car.rent.model.User;

import java.io.IOException;

@Component
public class Engine {
    @Autowired
    private IVehicleDB vehicleDB;
    @Autowired
    private IUserDB userDB2;
    @Autowired
    private GUI gui;
    @Autowired
    private Authenticator authenticator;
    //private static final Engine instance = new Engine();

    //private Engine() {}

    public void start() throws IOException {
        System.out.println(this.userDB2.getClass());
        boolean isWorking = authenticator.authenticate();

        while(isWorking) {
            gui.showMenu();
            switch(gui.getReader().readLine()) {
                case "1":
                    gui.listVehicles(vehicleDB.getVehicles());
                    break;
                case "2":
                    System.out.println("Plate:");
                    if(vehicleDB.rentVehicle(gui.getReader().readLine())) {
                        System.out.println("You have rent this vehicle !!!");
                    } else {
                        System.out.println("Rent error !!");
                    }
                    break;
                case "4":
                    gui.getReader().close();
                    vehicleDB.persistToFile();
                    userDB2.persistToFile();
                    isWorking = false;
                    break;
                case "3":
                    if(Authenticator.loggedUser.getRole() == User.Role.ADMIN) {
                        gui.addVehicle();
                        break;
                    }
                default:
                    System.out.println("Wrong choose !!");
                    break;
            }
        }
    }

    /*public static Engine getInstance() {
        return instance;
    }*/
}
