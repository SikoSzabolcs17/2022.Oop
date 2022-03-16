package models;

import enums.Degree;
import enums.Department;

public class Teacher {

    private final String firstName;
    private String lastName;
    private Degree degree;
    private Department department;
    private static int teacherID;

    public Teacher(String firstName, String lastName, Degree degree, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.degree = degree;
        this.department = department;
        teacherID = currentNumberOfTeachers() + 1;
    }
    public static int currentNumberOfTeachers(){
        return teacherID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public String getFirstName() {
        return firstName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public static int getTeacherID() {
        return teacherID;
    }

    @Override
    public String toString() {
        return "Teacher " +
                 firstName + " " +
                 lastName + " - " +
                 degree +
                " from " + department +
                " department\n";
    }
}
