package oop.labor11.labor11_2;


public class MyDate implements Comparable<MyDate> {
    private int  year, month, day;

    public MyDate(int year, int month,int day) throws InvalidDateException {

        if(!DateUtil.isValidDate(year,month,day)){
            throw new InvalidDateException("INVALID DATE: " + year + " " + month + " " + day);
        }
        this.year = year;
        this.month = month;
        this.day = day;

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
        int aux = year;
        date += Integer.toString(aux);
        date += ".";
        aux = month;
        date += Integer.toString(aux);
        date +=".";
        aux = day;
        date += Integer.toString(aux);
        return date;
    }

    @Override
    public int compareTo(MyDate that) {

        if(this.year == that.year){
            if(this.month == that.month){
                return this.day - this.month;
            }
            return this.month - that.month;
        }
        return this.year-that.year;
    }
}
