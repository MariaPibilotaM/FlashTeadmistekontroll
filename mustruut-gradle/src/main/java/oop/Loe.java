package oop;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class Loe {
    public String loe() throws IOException {
        File fail = new File("küsimused.txt");
        String read = Files.readString(fail.toPath(), Charset.forName("UTF-8"));
        return read;
    }
    public void kirjuta(String sõna) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("tulemus.txt"));
        /*for (int i = 0; i < sõna.length; i++) {
            writer.write(sõna[i]+"\n");
        }*/
        writer.append(sõna);
        writer.append("\n");
        //writer.close();
    }
}
