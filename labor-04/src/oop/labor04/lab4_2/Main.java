package oop.labor04.lab4_2;

import oop.labor04.lab4_1.Person;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Customer> arrayList = new ArrayList<>();

        try(Scanner scanner = new Scanner("labor4_2_input.txt")){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();

                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(",");
                if(items[0].equals("Customer")){

                    String firstName = items[1].trim();
                    String lastName = items[2].trim();

                    Customer person = new Customer(firstName,lastName);
                    arrayList.add(person);
                    //...
                }


            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
