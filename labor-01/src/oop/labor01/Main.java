package oop.labor01;

import java.util.Arrays;
import java.util.Random;


public class Main {

    public static double mean(double[] array){
        if(array.length==0)return Double.NaN;

        double sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum/array.length;
    }

    public static double stddev(double[] array){
        double average = mean(array);
        double sum = 0;

        for (int i = 0; i < array.length; i++) {
            double x = array[i]- average;
            sum += x*x;
        }
        return Math.sqrt(sum/array.length);
    }

    public static double[] max2(double[] array) {

        double[] max = {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY};
        if (array.length == 0) {
            return max;
        }
        else if(array.length == 1){
            max[0] = array[0];
            max[1] = array[0];
            return max;
        }

        for (int i = 0; i < array.length; i++) {

            if(array[i]>max[1]){
                max[0]=max[1];
                max[1]=array[i];
            }
        }
        return max;
    }
    public static int[] generateRandomNumbers(int number){
        Random  rand = new Random();

        int[] array = new int[number];

        for (int i = 0; i < number; i++) {
            array[i] = rand.nextInt(number); // hatar legyen a darabszam
        }
        return array;
    }

    public static void printNumberofDuplicates(int[] array){
        Arrays.sort(array);


        int counter = 0;

        for (int i = 1; i < array.length; i++) {
            if(array[i-1]==array[i]) {
                counter++;
            }
        }
        System.out.println(counter);
    }


    public static void main(String[] args) {
        /*int[] array = generateRandomNumbers(100000);
        printNumberofDuplicates(array);*/

    }
}
