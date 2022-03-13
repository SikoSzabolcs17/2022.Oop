package oop.labor04.lab4_2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Customer> readFile(){
        ArrayList<Customer> arrayList = new ArrayList<>();

        try(Scanner scanner = new Scanner(new File("lab4_2_input.txt"))){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();


                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(",");
                if(items[0].equals("Customer")){


                    Customer person = new Customer(items[1].trim(), items[2].trim());
                    arrayList.add(person);
                }
                else{
                    arrayList.get(arrayList.size()-1).addBankAccount(new BankAccount(items[1].trim()));
                    arrayList.get(arrayList.size()-1).getBankAccount(items[1].trim()).deposit(Integer.parseInt(items[2].trim()));
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return arrayList;
    }


    public static void main(String[] args) {

        ArrayList<Customer> arrayList = readFile();

        for (Customer customer:arrayList){
            System.out.println(customer);
        }
    }
}
