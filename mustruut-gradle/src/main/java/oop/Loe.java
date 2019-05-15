package oop;

import java.io.*;

public class Loe {
    public String loe() throws IOException {
        File fail = new File("C:\\Users\\Maria\\Desktop\\PROJEKT\\küsimused.txt");
        BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(fail),"UTF8"));

        String read = "";
        String line = br.readLine();
        if (line!=null) {
            read += line;
        }
        br.close();
        return read;
    }
}
