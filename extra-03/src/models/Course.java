package models;

import java.time.DayOfWeek;
import java.util.Arrays;

public class Course {

    private Teacher teacher;
    private String courseID;
    private final int numberOfCredits;
    private int numberOfEnrolledStudents;
    private Student[] enrolledStudents;
    private DayOfWeek dayOfWeek;

    private final static int MAX_STUDENTS = 120;

    public Course(String courseID,int numberOfCredits,DayOfWeek dayOfWeek){
        this.courseID = courseID;
        this.numberOfCredits = numberOfCredits;
        this.dayOfWeek = dayOfWeek;

        this.enrolledStudents = new Student[MAX_STUDENTS];
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public String getCourseID() {
        return courseID;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public int getNumberOfEnrolledStudents() {
        return numberOfEnrolledStudents;
    }

    public Student[] getEnrolledStudents() {
        return enrolledStudents;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void enrollStudent(Student student){
        this.enrolledStudents[this.numberOfEnrolledStudents] = student;
        this.numberOfEnrolledStudents++;
    }
    public void cancelEnrollmentOfStudent(String neptunCode){

        for (int i = 0; i < this.numberOfEnrolledStudents; i++) {

            if(enrolledStudents[i].getNeptunCode().equals(neptunCode)){

                for (int j = i; j < this.numberOfEnrolledStudents - 1; j++) {
                    enrolledStudents[j]=enrolledStudents[j+1];
                }
                enrolledStudents[this.numberOfEnrolledStudents-1] =null;
                this.numberOfEnrolledStudents--;
                return;
            }
        }

    }

    @Override
    public String toString() {

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(courseID + "\n" + teacher + "Credits: " + numberOfCredits + "\nOccurs every: " + dayOfWeek + "\n");
        stringBuffer.append("Enrollerd students: "+numberOfEnrolledStudents+"\n");

        for (int i = 0; i < numberOfEnrolledStudents; i++) {
            stringBuffer.append("- "+ enrolledStudents[i].getFirstName()+ " " +enrolledStudents[i].getLastName() + "("+enrolledStudents[i].getNeptunCode() + ")\n");
        }

        return stringBuffer.toString();

    }
}
