package pl.camp.it.car.rent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.camp.it.car.rent.configoration.AppConfiguration;
import pl.camp.it.car.rent.core.Engine;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        try {
            ApplicationContext pudeleczko =
                    new AnnotationConfigApplicationContext(AppConfiguration.class);
            Engine engine = pudeleczko.getBean(Engine.class);
            engine.start();
        } catch (IOException e) {
            System.out.println("Nie dziala wczytywanie z klawiatury !!");
        }
    }
}
