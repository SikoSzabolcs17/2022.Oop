package oop.labor10.lab10_2;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Company {
    private String name;
    private ArrayList<Employee>employees = new ArrayList<>();

    public Company(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void hire(Employee employee){

        if(!employees.contains(employee)){

            this.employees.add(employee);
        }
    }
    public void hireAll(String fileName){

    }
    public void fire(int ID){
        for (int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getID() == ID){
                employees.remove(i);
                return;
            }
        }
    }
    public void printAll(PrintStream printStream){

        for (Employee e:employees){
            printStream.println(e);
        }
    }
    public void sortByComparator(Comparator<Employee> employeeComparator){
        employees.sort(employeeComparator);
    }

}
