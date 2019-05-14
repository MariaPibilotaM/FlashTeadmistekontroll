package oop;

import javafx.application.Application;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class mäng {
    public static void main(String[] args) {
        String k1 = "Mis värvi on banaan?";
        String vastused = "kollane punane lilla";
        küsimused uus = new küsimused(k1,vastused);
        uus.start();
        launch(args);
        String k2 = "Mis värvi on maasikas?";
        String vastused2="kollane punane lilla";
        küsimused uus2 = new küsimused(k2,vastused2);
    }
}
