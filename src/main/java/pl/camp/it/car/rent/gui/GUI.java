package pl.camp.it.car.rent.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.camp.it.car.rent.Authenticator;
import pl.camp.it.car.rent.database.IVehicleDB;
import pl.camp.it.car.rent.database.VehicleDB;
import pl.camp.it.car.rent.model.Bus;
import pl.camp.it.car.rent.model.Car;
import pl.camp.it.car.rent.model.User;
import pl.camp.it.car.rent.model.Vehicle;
import pl.camp.it.car.rent.model.builders.MotorcycleBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Component
public class GUI {
    private final BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));
    @Autowired
    IVehicleDB vehicleDB;
    //private static final GUI instance = new GUI();

    //private GUI() {}
    public void showMenu() {
        System.out.println("1. List vehicles");
        System.out.println("2. Rent vehicle");
        if(Authenticator.loggedUser.getRole() == User.Role.ADMIN) {
            System.out.println("3. Add vehicle");
        }

        System.out.println("4. Exit");
    }

    public void listVehicles(List<Vehicle> vehicles) {
        for(Vehicle currentVehicle : vehicles) {
            System.out.println(currentVehicle);
        }
    }

    public User readLoginAndPassword() throws IOException {
        System.out.println("Login:");
        String login = reader.readLine();
        System.out.println("Password:");
        return new User(login, reader.readLine());
    }

    public void addVehicle() throws IOException {
        System.out.println("1. Car");
        System.out.println("2. Bus");
        System.out.println("3. Motorcycle");
        String type = reader.readLine();
        switch (type) {
            case "1":
                Car car = new Car();
                System.out.println("Brand:");
                car.setBrand(reader.readLine());
                System.out.println("Model:");
                car.setModel(reader.readLine());
                System.out.println("Year:");
                car.setYear(Integer.parseInt(reader.readLine()));
                car.setRent(false);
                System.out.println("Plate:");
                car.setPlate(reader.readLine());
                System.out.println("Price:");
                car.setPrice(Double.parseDouble(reader.readLine()));
                vehicleDB.addVehicle(car);
                System.out.println("Car added !!");
                break;
            case "2":
                Bus bus = new Bus();
                System.out.println("Brand:");
                bus.setBrand(reader.readLine());
                System.out.println("Model:");
                bus.setModel(reader.readLine());
                System.out.println("Year:");
                bus.setYear(Integer.parseInt(reader.readLine()));
                bus.setRent(false);
                System.out.println("Plate:");
                bus.setPlate(reader.readLine());
                System.out.println("Price:");
                bus.setPrice(Double.parseDouble(reader.readLine()));
                System.out.println("Seats:");
                bus.setSeats(Integer.parseInt(reader.readLine()));
                vehicleDB.addVehicle(bus);
                System.out.println("Bus added !!");
                break;
            case "3":
                MotorcycleBuilder mb = new MotorcycleBuilder();
                System.out.println("Brand:");
                mb.brand(reader.readLine());
                System.out.println("Model:");
                mb.model(reader.readLine());
                System.out.println("Year:");
                mb.year(Integer.parseInt(reader.readLine()));
                System.out.println("Plate:");
                mb.plate(reader.readLine());
                System.out.println("Price:");
                mb.price(Double.parseDouble(reader.readLine()));
                System.out.println("Has cart (y/n):");
                mb.cart(reader.readLine().equals("y"));
                vehicleDB.addVehicle(mb.build());
                System.out.println("Motorcycle added !!");
                break;
            default:
                System.out.println("Wrong choose !!");
                break;
        }
    }

    /*public static GUI getInstance() {
        return instance;
    }*/

    public BufferedReader getReader() {
        return reader;
    }
}
