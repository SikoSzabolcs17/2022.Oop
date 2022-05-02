package oop.labor10.lab10_2;

import oop.labor10.lab10_1.MyDate;

import java.util.Comparator;

public class Employee {
    private final int ID;
    private final String firstName;
    private String lastName;
    private double salary;
    private final MyDate birtDate;

    private static int counter = 1;

    public static Comparator<Employee> comperByFullName = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            String o1Name = o1.getFirstName() + o2.getLastName();
            String o2Name = o2.getFirstName() + o2.getLastName();
            return o1Name.compareTo(o2Name);
        }
    };

    public static Comparator<Employee> comperBySaleryDesc = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Double.compare(o2.getSalary(),o1.getSalary());
        }
    };

    public static Comparator<Employee> sortByManagerFirstAlphabetic = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            if(o1.getClass() != o2.getClass()){
                if(o1.getClass() == Manager.class){
                    return -1;
                }
                else{
                    return 1;
                }
            }
            String o1Name = o1.getFirstName() + o2.getLastName();
            String o2Name = o2.getFirstName() + o2.getLastName();
            return o1Name.compareTo(o2Name);
        }
    };

    public Employee(String firstName, String lastName, double salary, MyDate birtDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.birtDate = birtDate;

        this.ID = counter;
        counter++;
    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public MyDate getBirtDate() {
        return birtDate;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", birtDate=" + birtDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return ID == employee.ID;
    }

}
