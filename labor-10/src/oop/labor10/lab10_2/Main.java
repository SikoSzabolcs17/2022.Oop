package oop.labor10.lab10_2;

import oop.labor10.lab10_1.MyDate;

public class Main {
    public static void main(String[] args) {

        Company company = new Company("Microsoft");

        company.hireAll("employees.csv");

        company.printAll(System.out);

        /*
        company.sortByComparator(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getBirtDate().compareTo(o2.getBirtDate());
            }
        });

         */
        //company.sortByComparator(Comparator.comparing(Employee::getFirstName));

        company.sortByComparator(Employee.sortByManagerFirstAlphabetic);

        System.out.println("\nAfter Sort:\n");

        company.printAll(System.out);

    }
}
