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
            for (int j = 0; j < bank.getCustomer(i).getNumAccounts(); j++) {
                bank.getCustomer(i).getBankAccountWithIndex(j).deposit(random.nextInt(100,1500));
            }
        }

        for (int i = 1; i <= bank.numCustomers(); i++) {
            System.out.println(bank.getCustomer(i));
        }


        for (int i = 1; i <= bank.numCustomers(); i++) {
            for (int j = 0; j < bank.getCustomer(i).getNumAccounts(); j++) {
                if(bank.getCustomer(i).getBankAccountWithIndex(j) instanceof SavingsAccount){
                    ((SavingsAccount) bank.getCustomer(i).getBankAccountWithIndex(j)).addIntrest();
                }
            }
        }
        for (int i = 1; i <= bank.numCustomers(); i++) {
            System.out.println(bank.getCustomer(i));
        }


        for (int i = 1; i <= bank.numCustomers(); i++) {
            for (int j = 0; j < bank.getCustomer(i).getNumAccounts(); j++) {

                double value = random.nextInt(1000);

                if(bank.getCustomer(i).getBankAccountWithIndex(j).withdraw(value)){
                    System.out.println("Sikeres tranzakcio!" + "- " + value +" lej atutalva " + bank.getCustomer(i).getBankAccountWithIndex(j).getAccountNumber() + " szamlarol");
                }
                else {
                    System.out.println("Sikertelen tranzakcio! - " +  value +" nincs ennyi forras " + bank.getCustomer(i).getBankAccountWithIndex(j).getAccountNumber() + " szamlan") ;
                }

            }
        }
        System.out.println();
        for (int i = 1; i <= bank.numCustomers(); i++) {
            System.out.println(bank.getCustomer(i));
        }



    }
}
