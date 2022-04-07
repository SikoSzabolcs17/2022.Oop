package oop.labor08.lab8_1.utils;

import oop.labor08.lab8_1.bank.Bank;
import oop.labor08.lab8_1.customer.Customer;
import oop.labor08.lab8_1.models.BankAccount;
import oop.labor08.lab8_1.models.CheckingAccount;
import oop.labor08.lab8_1.models.SavingsAccount;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("OTP");

        bank.addCustomer(new Customer("Kovacs","Janos"));
        bank.addCustomer(new Customer("Kis","Bela"));

        Random random = new Random();

        for (int i = 1; i <= bank.numCustomers(); i++) {
            bank.getCustomer(i).addBankAccount(new CheckingAccount(random.nextInt(100,1000)));
            bank.getCustomer(i).addBankAccount(new SavingsAccount(0.02));
        }
        for (int i = 1; i <= bank.numCustomers(); i++) {
            System.out.println(bank.getCustomer(i));
        }

        for (int i = 1; i <= bank.numCustomers(); i++) {
            System.out.println(bank.getCustomer(i));
        }



    }
}
