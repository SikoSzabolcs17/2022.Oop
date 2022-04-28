package oop.labor10.lab10_2;

import oop.labor10.lab10_1.MyDate;

public class Main {
    public static void main(String[] args) {

        Company company = new Company("Microsoft");

        company.hire(new Manager("Patricia","Schifler",6000, new MyDate(2002,3,5),"Frontend"));

        company.hire(new Employee("Robert","Ambrus",4000,new MyDate(2002,4,11)));
        company.hire(new Employee("Kinga","Olah",4000,new MyDate(1999,6,21)));
        company.hire(new Employee("Johanna","Rigmannyi",4000,new MyDate(2002,12,22)));

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

        company.sortByComparator(Employee.comperByFullName);

        System.out.println("\nSorted by birth date\n");

        company.printAll(System.out);

    }
}
