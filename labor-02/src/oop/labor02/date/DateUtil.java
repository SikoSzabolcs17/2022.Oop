package oop.labor02.date;

public class DateUtil {

    public static  boolean leapYear(int year){
        if(year%4 == 0 && (year%100!=0 || year%400==0)){
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean isValidDate(int year, int month, int day){
        if(year>0 && month >=1 && month<=12 && day>=1){
            if(month==2 && day>28) {
                if (day == 29 && leapYear(year)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        else return false;

        if(day>30 && day<32) {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 7 || month == 10 || month == 12) {
                return true;
            }
            else return false;
        }
        return true;

    }
}
