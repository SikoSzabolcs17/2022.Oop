package oop.labor05;

import oop.labor02.date.MyDate;
import oop.labor05.models.Course;
import oop.labor05.models.Student;
import oop.labor05.models.Training;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static ArrayList<Course> readCourses(String filename){
        ArrayList<Course> courses = new ArrayList<>();

        try(Scanner scanner = new Scanner(new File(filename))){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();

                if(line.isEmpty()){
                    continue;
                }
                String[] items = line.split(",");

                courses.add(new Course(items[0].trim(),items[1].trim(),Integer.parseInt(items[2].trim())));
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return courses;
    }
    private static void printCourses(ArrayList<Course> courses){
        for (Course course: courses){
            System.out.println(course);
        }
        System.out.println();
    }
    private static ArrayList<Student> readStudents(String filename){
        ArrayList<Student> studentArrayList =new ArrayList<>();

        try(Scanner scanner = new Scanner(new File(filename))){
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(",");
                studentArrayList.add(new Student(items[0].trim(),items[1].trim(),items[2].trim()));
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return studentArrayList;
    }
    private static void printStudents(ArrayList<Student> studentArrayList){
        for(Student student: studentArrayList){
            System.out.println(student);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ArrayList<Course>courses = readCourses("courses.csv");
        printCourses(courses);
        ArrayList<Student>studentArrayList =readStudents("students.csv");
        printStudents(studentArrayList);

        ArrayList<Training>trainingArrayList = new ArrayList<>();

        for (Course course:courses){

            Random random = new Random();
            int day1 = random.nextInt(21,26);
            int day2 = random.nextInt(21,26);

            if(day1>day2){
                int aux = day1;
                day1 = day2;
                day2 = day1;
            }
            double price = random.nextDouble(1000,2000);

            trainingArrayList.add(new Training(course,new MyDate(2022,3,day1),
                    new MyDate(2020,3,day2),price));

            int counter = 0;

            while (counter<10 && counter<trainingArrayList.size()){
                int index = random.nextInt(0,trainingArrayList.size());

                if(trainingArrayList.get(counter).enroll(studentArrayList.get(index))){
                    counter++;
                }
            }
        }
        for(Training training: trainingArrayList){
            training.printToFile();
        }
    }
}
