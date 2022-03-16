import enums.Degree;
import enums.Department;
import enums.Major;
import models.Course;
import models.Student;
import models.Teacher;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.util.Scanner;

public class Main {

    private static final int MAX_COURSES = 50;

    static Course[] courses = new Course[MAX_COURSES];
    static int courseCounter = 0;

    static void readCourseFile(String fileName){

        int counter = 0;

        Department[] departments = new Department[7];
        departments = Department.values();

        try(Scanner scanner = new Scanner(new File(fileName))){

            while(scanner.hasNextLine()){

                String line = scanner.nextLine();


                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(",");


                courses[counter] = new Course(items[0].trim(),Integer.parseInt(items[1].trim()),DayOfWeek.of(Integer.parseInt(items[2].trim())));

                line = scanner.nextLine();


                items = line.split(",");


                courses[counter].setTeacher(new Teacher(items[0].trim(),items[1].trim(),Degree.valueOf(items[2].trim()), departments[Integer.parseInt(items[3].trim())-1]));

                counter++;
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        courseCounter = counter;
    }
    static void printCourses(){
        for (int i = 0; i < courseCounter; i++) {
            System.out.println(courses[i]);
        }
    }
    static Course getCourseById(String courseId){
        for (Course course: courses){
            if(course.getCourseID().equals(courseId)){
                return course;
            }
        }
        return null;
    }

    static void readStudentsFile(String fileName){
        try(Scanner scanner = new Scanner(new File(fileName))){
            while (scanner.hasNextLine()){

                String line = scanner.nextLine();

                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(",");


                line = scanner.nextLine();

                String[] courses = line.split(",");

                for (int i = 0; i < courses.length; i++) {
                    Course course =  getCourseById(courses[i]);
                    course.enrollStudent(new Student(items[0].trim(),items[1].trim(),items[2].trim(),Major.valueOf(items[3].trim())));
                }
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    static void printEnrolledStudentsByMajor(Major major,String courseId){

        System.out.println("Students from: " + major + " whom enrolled with a course which has ID:" + courseId);

        for (int i = 0; i < courses.length; i++) {
            if(courses[i].getCourseID().equals(courseId)){

                Student[] students =  courses[i].getEnrolledStudents();

                for (int j = 0; j < courses[i].getNumberOfEnrolledStudents(); j++) {
                    if(students[j].getMajor().equals(major)){
                        System.out.println("  -"+students[j]);
                    }
                }
            }
        }

    }

    public static Course[] coursesByTeacherDegree(Degree degree){
        Course[] coursesByDegree = new Course[MAX_COURSES];
        int counter=0;

        for (int i = 0; i < courses.length; i++) {
            if(courses[i].getTeacher().getDegree().equals(degree)){

                coursesByDegree[counter++]=courses[i];
            }
        }
        return coursesByDegree;

    }

    public static int nrOfCoursesByDay(DayOfWeek day){
        int counter = 0;
        for (int i = 0; i < courses.length; i++) {
            if(courses[i].getDayOfWeek().equals(day)){
                counter++;
            }
        }
        return counter;
    }
    public static void cancelEnrollments(String fileName){
        try(Scanner scanner = new Scanner(new File(fileName))){

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();

                if(line.isEmpty()){
                    continue;
                }
                line = line.trim();

                for (int i = 0; i < courses.length; i++) {
                   courses[i].cancelEnrollmentOfStudent(line);
                }
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        readCourseFile("extra3_university.csv");
        readStudentsFile("extra3_students.csv");
        printCourses();
        System.out.println("\n--------------------------\n");
        cancelEnrollments("extra3_cancellation.csv");
        printCourses();

    }
}
