package models;

import enums.Major;

public class Student {

    private String neptunCode;
    private String firstName;
    private String lastName;
    private Major major;

    public Student(String neptunCode, String firstName, String lastName, Major major) {
        this.neptunCode = neptunCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNeptunCode() {
        return neptunCode;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return firstName + " "+ lastName + " " + neptunCode + " major: " + major;
    }
}
