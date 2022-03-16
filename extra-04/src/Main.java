import models.Course;
import models.Student;
import models.Teacher;
import utils.Degree;
import utils.Department;
import utils.Major;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Degree degree = new Degree();
    static Department department = new Department();
    static Major major = new Major();
    static ArrayList<Course> courses;



    static ArrayList<Course> readCourseFile(String fileName){

        ArrayList<Course>courses =new ArrayList<>();

        try(Scanner scanner = new Scanner(new File(fileName))){

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();

                if(line.isEmpty()){
                    continue;
                }
                String[] items = line.split(",");

                courses.add(new Course(items[0].trim(),Integer.parseInt(items[1].trim()),DayOfWeek.of(Integer.parseInt(items[2].trim()))));

                line = scanner.nextLine();

                items = line.split(",");

                degree.alreadyInList(items[2].trim());
                department.alreadyInList(items[3].trim());

                courses.get(courses.size()-1).setTeacher(new Teacher(items[0].trim(),items[1].trim(),items[2].trim(),items[3].trim()));
            }

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return courses;
    }
    static Course getCourseById(String courseId){
        for (Course course: courses){
            if(course.getCourseID().equals(courseId)){
                return course;
            }
        }
        return null;
    }

    static void readStudentsFile(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(",");


                line = scanner.nextLine();

                String[] courseIds = line.split(",");

                major.alreadyInList(items[3].trim());

                for (int i = 0; i < courseIds.length; i++) {
                    Course course = getCourseById(courseIds[i]);
                    course.enrollStudent(new Student(items[0].trim(),items[1].trim(),items[2].trim(),items[3].trim()));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void printCourses(){
        for (Course course:courses){
            System.out.println(course);
        }
    }
    static void printEnrolledStudentsByMajor(String major,String courseId){

        System.out.println("Students from: " + major + " whom enrolled with a course which has ID:" + courseId);

        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getCourseID().equals(courseId)){

                ArrayList<Student> students =  courses.get(i).getEnrolledStudents();

                for (int j = 0; j < courses.get(i).getNumberOfEnrolledStudents(); j++) {

                    if(students.get(j).getMajor().equals(major)){
                        System.out.println("  -"+students.get(j));
                    }
                }
            }
        }
    }
    public static ArrayList<Course> coursesByTeacherDegree(String degree){
        ArrayList<Course> coursesByDegree = new ArrayList<>();
        int counter=0;

        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getTeacher().getDegree().equals(degree)){

                coursesByDegree.add(courses.get(i));
            }
        }
        return coursesByDegree;

    }

    public static int nrOfCoursesByDay(DayOfWeek day,ArrayList<Course> courses){
        int counter = 0;
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getDayOfWeek().equals(day)){
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

                for (int i = 0; i < courses.size(); i++) {
                    courses.get(i).cancelEnrollmentOfStudent(line);
                }
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        courses = readCourseFile("extra4_university.csv");
        readStudentsFile("extra4_students.csv");
        printCourses();
        System.out.println("\n---------------------------\n");
        cancelEnrollments("extra4_cancellation.csv");
        printCourses();
    }
}
