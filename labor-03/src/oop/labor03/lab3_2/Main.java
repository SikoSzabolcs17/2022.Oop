package oop.labor03.lab3_2;

import oop.labor03.lab3_1.BankAccount;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Customer customer1 = new Customer("John", "BLACK");
        Customer customer2 = new Customer("Mary","WHITE");

        for (int i = 0; i < 5; i++) {
            String accountNumber = "OTP000";
            customer1.addBankAccount(new BankAccount(accountNumber+i));
        }
        for (int i = 0; i < 9; i++) {
            String accountNumber = "OTP010";
            customer2.addBankAccount(new BankAccount(accountNumber+i));
        }
        Random rand = new Random();
        for (int i = 0; i < customer1.getNumAccounts(); i++) {
                customer1.getBankAccount(customer1.bankAccountNumberWithIndex(i)).deposit(rand.nextInt(10,1000));
        }
        for (int i = 0; i < customer2.getNumAccounts(); i++) {
            customer2.getBankAccount(customer2.bankAccountNumberWithIndex(i)).deposit(rand.nextInt(10,1000));
        }

        System.out.println(customer1);
        System.out.println(customer2);

        customer1.closeAccount(customer1.bankAccountNumberWithIndex(0));
        customer2.closeAccount(customer2.bankAccountNumberWithIndex(customer2.getNumAccounts()-1));

        System.out.println(customer1);
        System.out.println(customer2);

    }


}
