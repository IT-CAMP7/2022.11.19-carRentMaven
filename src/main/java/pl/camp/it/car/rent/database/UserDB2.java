package pl.camp.it.car.rent.database;

import org.springframework.stereotype.Component;
import pl.camp.it.car.rent.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDB2 implements IUserDB {
    private final Map<String, User> users = new HashMap<>();
    private final String USER_DB_FILE = "users.txt";
    private static final UserDB2 instance = new UserDB2();

    private UserDB2() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(USER_DB_FILE));
            String line;
            while((line = reader.readLine()) != null) {
                String[] params = line.split(";");
                this.users.put(params[0],
                        new User(params[0], params[1], User.Role.valueOf(params[2])));
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("plik nie dziala !!");
        }
    }

    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    public User findUserByLogin(String login) {
        return this.users.get(login);
    }

    public void persistToFile() {
        try {
            BufferedWriter writer =
                    new BufferedWriter(new FileWriter(this.USER_DB_FILE));
            boolean flag = false;
            for(User user : this.users.values()) {
                if(flag) {
                    writer.newLine();
                }
                flag = true;
                writer.write(user.convertToData());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Cos sie zepsulo podczas zapisu");
            e.printStackTrace();
        }
    }

    public static UserDB2 getInstance() {
        return instance;
    }
}
