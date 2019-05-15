package oop;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class Loe {
    public String loe() throws IOException {
        File fail = new File("küsimused.txt");
        /*BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(fail),"UTF8"));*/

        String read = Files.readString(fail.toPath(), Charset.forName("UTF-8"));
        System.out.println(read);

        /*String read = "";
        String line = br.readLine();
        while (line!= null) {
            read += line+"\n";
            line = br.readLine();
        }
        br.close();*/
        return read;
    }
}
