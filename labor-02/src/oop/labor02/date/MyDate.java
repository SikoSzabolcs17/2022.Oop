package oop.labor02.date;

import static oop.labor02.date.DateUtil.isValidDate;

public class MyDate {
    private int  year, month, day;

    public MyDate(int year, int month,int day){
        if(isValidDate(year,month,day)){

            this.year = year;
            this.month=month;
            this.day =day;
        }
    }
    public int getYear(){
        return this.year;
    }
    public int getMonth(){
        return this.month;
    }
    public int getDay(){
        return this.day;
    }
    public String toString(){

        String date="";
        Integer aux = new Integer(year);
        date += aux.toString();
        date += ". ";
        aux = month;
        date += aux.toString();
        date +=". ";
        aux = day;
        date +=aux.toString();
        return date;
    }
}
