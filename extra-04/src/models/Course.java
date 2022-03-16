package models;

import java.time.DayOfWeek;
import java.util.ArrayList;

public class Course {

    private Teacher teacher;
    private String courseID;
    private final int numberOfCredits;
    private ArrayList<Student> students;
    private DayOfWeek dayOfWeek;

    public Course(String courseID,int numberOfCredits,DayOfWeek dayOfWeek){

        this.students =  new ArrayList<>();

        this.courseID = courseID;
        this.numberOfCredits = numberOfCredits;
        this.dayOfWeek = dayOfWeek;
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
        return students.size();
    }

    public ArrayList<Student> getEnrolledStudents() {
        return students;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void enrollStudent(Student student){
        students.add(student);
    }
    public void cancelEnrollmentOfStudent(String neptunCode){

        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getNeptunCode().equals(neptunCode)){
                students.remove(i);
            }
        }

    }

    @Override
    public String toString() {

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(courseID + "\n" + teacher + "Credits: " + numberOfCredits + "\nOccurs every: " + dayOfWeek + "\n");

        if(students.size()>0){
            stringBuffer.append("Enrollerd students: "+ students.size()+"\n");
        }

        for (int i = 0; i < students.size(); i++) {
            stringBuffer.append("- "+ students.get(i).getFirstName()+ " " +students.get(i).getLastName() + "("+students.get(i).getNeptunCode() + ")\n");
        }

        return stringBuffer.toString();

    }
}
