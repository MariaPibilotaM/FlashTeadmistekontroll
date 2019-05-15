package oop;

import java.io.IOException;

public class FailiLugErind extends IOException { //Erindi tegemine

    public FailiLugErind(String kirjeldus, String message) { //Kui erindi välja kutsumine
        System.out.println(kirjeldus + "      " + message); //Sisestatud kirjeldus ja tekkinud erindile vastav tekst
    }
}
