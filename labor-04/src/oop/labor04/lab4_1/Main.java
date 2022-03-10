package oop.labor04.lab4_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void readFilePrintItsLineNumbered( String fileName ){

        //Scanner scanner = new Scanner(System.in);

        try (Scanner scanner = new Scanner( new File(fileName))){
            int counter = 1;
            while (scanner.hasNextLine()){
                System.out.println(counter + " " + scanner.nextLine());
                counter++;

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Person> readFromCSVFile(String fileName) {
        ArrayList<Person> persons = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(",");

                String firstName = items[0].trim();
                String lastName = items[1].trim();

                int birtYear = Integer.parseInt(items[2].trim());
                persons.add(new Person(firstName, lastName, birtYear));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return persons;
    }



    public static void main(String[] args) {
        readFilePrintItsLineNumbered("lab4_1_input.txt");

        ArrayList<Person> personArrayList = readFromCSVFile("lab4_1_input.csv");


        for (Person person: personArrayList){
            System.out.println(person);
        }


    }
}
