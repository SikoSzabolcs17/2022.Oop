package oop.labor11.labor11_2;

public class InvalidDateException extends Throwable {
    public InvalidDateException(String invalid_date) {
        System.out.println(invalid_date);
    }
}
