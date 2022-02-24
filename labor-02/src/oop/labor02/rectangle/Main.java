package oop.labor02.rectangle;


import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Rectangle[] rectangles = new Rectangle[ 10 ];
        Random rand = new Random();

        double totalArea = 0;

        for (int i = 0; i < 10; i++) {

            double length = 1 + rand.nextInt(10);
            double width = 1 + rand.nextInt(10) ;
            rectangles[ i ] = new Rectangle(length, width);

            totalArea += rectangles[i].area();

            System.out.println("Length: " + rectangles[i].getLength() + " Width: " + rectangles[i].getWidth());
            System.out.println("Area: " + rectangles[i].area() + " Perimeter: " + rectangles[i].perimeter());
            System.out.println();
        }

        System.out.println("Total Area:" +  totalArea);
    }

}
