package oop.labor11.lab11_1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        System.out.println("Adj meg szamokat szokozzel elvasztva:");
        String line = scanner.nextLine();
        String[] numbers = line.split(" ");

        for (String number : numbers) {
            try {
                sum += Double.parseDouble(number.trim());
            }
            catch (NumberFormatException e){
                System.out.println("Hibas input " + number + " nem szam!");
            }
        }
        System.out.println("Osszeg:" + sum);
    }

}
