package oop.labor11.labor11_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Student> readFromCSVFile(String fileName) {
        ArrayList<Student> students = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(",");

                try {
                    String neptun = items[0].trim();
                    String firstName = items[1].trim();
                    String lastName = items[2].trim();
                    int credits = Integer.parseInt(items[3].trim());
                    int birthYear = Integer.parseInt(items[4].trim());
                    int birthMonth = Integer.parseInt(items[5].trim());
                    int birthDay = Integer.parseInt(items[6].trim());

                    students.add(new Student(neptun,firstName,lastName,credits,birthYear,birthMonth,birthDay));
                }
                catch (ArrayIndexOutOfBoundsException ex){
                    System.out.println("INCOMPLETE LINE:" + line);
                }
                catch (NumberFormatException ex){
                    System.out.println("Number format Exception" + line);
                }
                catch (InvalidDateException e){
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(!students.isEmpty()){
            System.out.println(students);
        }
        return students;
    }

    public static void main(String[] args) {
        readFromCSVFile("student.csv");
    }
}
