package oop.labor05.models;

import oop.labor02.date.MyDate;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

public class Training {
    private final Course course;
    private final MyDate startDate;
    private final MyDate endDate;
    private final double pricePerStudent;
    private ArrayList<Student> enrolledStudents;

    public Training(Course course, MyDate startDate, MyDate endDate, double pricePerStudent) {
        this.course = course;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pricePerStudent = pricePerStudent;

        enrolledStudents = new ArrayList<>();
    }
    public boolean enroll(Student student){
        if(enrolledStudents.contains(student)){
            return false;
        }
        else{
            enrolledStudents.add(student);
            return true;
        }
    }
    public Student findById(String id){
        for (Student student:this.enrolledStudents){
            if(student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }

    public Course getCourse() {
        return course;
    }
    public int numEnrolled(){
        return this.enrolledStudents.size();
    }
    public void printToFile(){
        String fileName = String.format("%s_%s_s.csv",course.getName(),startDate,endDate);

        try(PrintStream printStream = new PrintStream(new File(fileName))){

            printStream.println(course.getName() +" Number of hours: "+ course.getNumHours());
            printStream.println(course.getDescription());

            for(Student student:enrolledStudents){
                printStream.println("  -"+student);
            }
            printStream.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void unEnroll(String id){
        this.enrolledStudents.remove(findById(id));
    }
}
