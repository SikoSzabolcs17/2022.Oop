package oop.labor10.lab10_2;

import oop.labor10.lab10_1.MyDate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

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

        try(Scanner scanner = new Scanner(new File(fileName))){

            while (scanner.hasNextLine()){

                String line = scanner.nextLine();
                if (line.isEmpty()){
                    continue;
                }
                String[] args = line.split(",");


                if(args.length == 6){
                    this.employees.add(new Employee(args[0].trim(),args[1].trim(),Double.parseDouble(args[2].trim()),
                            new MyDate(Integer.parseInt(args[3].trim()),Integer.parseInt(args[4].trim()),Integer.parseInt(args[5].trim()))));
                }
                else{
                    this.employees.add(new Manager(args[0].trim(),args[1].trim(),Double.parseDouble(args[2].trim()),
                            new MyDate(Integer.parseInt(args[3].trim()),Integer.parseInt(args[4].trim()),Integer.parseInt(args[5].trim())),args[6].trim()));
                }
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

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
