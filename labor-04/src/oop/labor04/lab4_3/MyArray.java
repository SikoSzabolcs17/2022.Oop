package oop.labor04.lab4_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MyArray {
    private int length;
    private double[] elements;

    public MyArray(int length){
        this.elements = new double[length];
        this.length = length;
    }
    public MyArray(MyArray myArray){

        this.length = myArray.length;

        this.elements = new double[length];

        for (int i = 0; i < length; i++) {
            this.elements[i] = myArray.elements[i];
        }
    }
    public MyArray(double[] elements){

        this.elements = new double[elements.length];

        for (int i = 0; i < elements.length; i++) {
            this.elements[i] = elements[i];
        }
        this.length = elements.length;
    }
    public MyArray(String fileName){

        try(Scanner scanner = new Scanner(new File(fileName))){

            this.length = scanner.nextInt();

            this.elements = new double[this.length];

            for (int i = 0; i < this.length; i++) {
                elements[i] = scanner.nextDouble();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void fillRandom(double lower, double upper){
        Random random = new Random();

        for (int i = 0; i < this.length; i++) {
            elements[i]  = random.nextDouble(lower,upper);
        }
    }
    public double mean(){
        double sum = 0;
        for (double item: elements){
            sum += item;
        }
        return sum/this.length;
    }
    public double stddev(){

        double average = mean();
        double sum = 0;

        for (int i = 0; i < length; i++) {
            double x = elements[i] - average;
            sum += x*x;
        }
        return Math.sqrt(sum/ length);
    }
    public void sort(){
        Arrays.sort(this.elements);
    }
    public void print(String name){

        System.out.print(name + " ");

        for(double item:elements){
            System.out.print(item + " ");
        }
        System.out.println();
    }


}
