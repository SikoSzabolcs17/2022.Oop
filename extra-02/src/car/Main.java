package car;

import car.Car;

import java.util.Random;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) {

            Scanner Reader = new Scanner(System.in);

            int numberOfCars = Reader.nextInt();

            Car[] cars = new Car[numberOfCars];

            Random rand = new Random();

            for (int i = 0; i < numberOfCars; i++) {
                String carBrand = Reader.next();
                String cartype = Reader.next();
                int yearOfManufacture = Reader.nextInt();

                int fuelType = rand.nextInt(1,3);
                int capacity = rand.nextInt(0,1);

                boolean familyFriendly;

                if(capacity > 0)familyFriendly = true;
                else familyFriendly = false;

                cars[i] = new Car(carBrand,cartype,fuelType,familyFriendly,yearOfManufacture);

                cars[i].toString();

            }
            int numberOfDiesels=0;
            int numberOfRedCars=0;

        for (int i = 0; i < numberOfCars; i++) {
            if(cars[i].getFuelType() == FuelType.DIESEL)
                numberOfDiesels++;

            if(cars[i].getColor()==Color.RED)
                numberOfRedCars++;
        }
        System.out.println("Number of Diesel cars is: " + numberOfDiesels);
        System.out.println("Number of Red cars is: " + numberOfDiesels);

        System.out.println("It’s time to travel.\n");

        int numberOfTimes = Reader.nextInt();

        int index = -1;

        for (int i = 0; i < numberOfTimes && index==-1; i++) {
            int distance = rand.nextInt(1,50);
            for (int j = 0; j < numberOfCars && index==-1; j++) {

                cars[j].moveCar(distance);
                if(cars[j].getSpeed()>180) {

                    cars[j].changeSpeed(cars[i].getSpeed() + 10);
                }
                else{
                    System.out.println("Slowdown, your speed is too high");
                }
                int numberOfKilometers = cars[j].getNumberOfKilometers();

                cars[j].resetMileage();

                if(numberOfKilometers!=cars[j].getNumberOfKilometers()){
                    index = j;
                }
            }
        }
        System.out.println(index +  " " + cars[index].getCarBrand());


        /*
3
Ford Fiesta 2002
VW Passat 2000
Audi A4 2017


         */


    }
}