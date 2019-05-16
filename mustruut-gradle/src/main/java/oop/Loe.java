package oop;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Loe {
    public String loe() throws IOException {
        String read;
        try{
        File fail = new File("küsimused.txt");
        read = Files.readString(fail.toPath(), Charset.forName("UTF-8"));
            return read;}
        catch (FailiLugErind e){
            throw new FailiLugErind("Error","Tekkinud on failist lugemise erind!");
        }
    }
    public void kirjuta(ArrayList sõna) throws IOException {
        int kokku = 0;
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("tulemus.txt"));
            writer.write("UUS KATSE"+ "\n");
        for (int i = 0; i < sõna.size(); i++) {
            if(sõna.get(i).toString().contains("Õige")){
                kokku++;
            }
            writer.append(sõna.get(i) + "\n");

        }
            System.out.println("Sinu tulemus oli: "+kokku+"/"+sõna.size());
        writer.close();}
        catch (FailiLugErind e){
            throw new FailiLugErind("Error! ","Ei saanud faili kirjutada :(");
        }
    }
}
