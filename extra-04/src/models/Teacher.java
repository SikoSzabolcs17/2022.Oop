package models;

public class Teacher {
    private String firstName;
    private String lastName;
    private String degree;
    private String department;
    private static int teacherID;

    public Teacher(String firstName, String lastName, String degree, String department) {
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

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
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
                " \n";
    }

}
