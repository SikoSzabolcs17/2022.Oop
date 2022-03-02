package oop.labor02.date;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        MyDate date = new MyDate(2002,3,17);
        System.out.println(date.toString());

        System.out.println(DateUtil.isValidDate(2000,2, 29) == true);
        System.out.println(DateUtil.isValidDate(2000,2, 30) == false);
        System.out.println(DateUtil.isValidDate(1900,2, 29) == false);
        System.out.println(DateUtil.isValidDate(1900,2, 28) == true);
        System.out.println(DateUtil.isValidDate(-1900,2, 28) == false);
        System.out.println(DateUtil.isValidDate(0,2, 28) == false);
        System.out.println(DateUtil.isValidDate(2021,2, 29) == false);
        System.out.println(DateUtil.isValidDate(2020,2, 29) == true);
        System.out.println(DateUtil.isValidDate(2020,1, 32) == false);
        System.out.println(DateUtil.isValidDate(2020,1, 0) == false);
        System.out.println(DateUtil.isValidDate(2020,0, 0) == false);
        System.out.println(DateUtil.isValidDate(2020,4, 31) == false);

        Random rand = new Random();

        int counter = 0;

        for (int i = 0; i < 1000; i++) {
            int year = rand.nextInt(10000);
            int month = rand.nextInt(1,12);
            int day = rand.nextInt(1,31);


            if(DateUtil.isValidDate(year,month,day)) {
                counter++;
                MyDate date1 = new MyDate(year,month,day);
                System.out.println(date1.toString());
            }
        }
        System.out.println("Number of Valid dates: " + counter);

    }
}
