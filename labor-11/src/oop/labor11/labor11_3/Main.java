package oop.labor11.labor11_3;

import java.io.IOException;

public class Main{
    public static void main(String[] args) {
        try {
            FileUtil.encode("FileUtil.java", "temp1.txt");
            FileUtil.decode("temp1.txt", "temp2.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
