package oop.labor10.lab10_2;

import oop.labor10.lab10_1.MyDate;

public class Manager extends Employee{

    private String department;

    public Manager(String firstName, String lastName, double salary, MyDate birtDate, String department) {

        super(firstName, lastName, salary, birtDate);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "department='" + department + '\'' +
                "} " + super.toString();
    }
}
