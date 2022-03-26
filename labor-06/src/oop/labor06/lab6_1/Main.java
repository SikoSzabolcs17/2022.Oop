package oop.labor06.lab6_1;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank("OTP");

        bank.addCustomer(new Customer("John","Black"));
        bank.getCustomer(bank.numCustomers()).addBankAccount(new BankAccount());
        bank.getCustomer(bank.numCustomers()).addBankAccount(new BankAccount());

        bank.getCustomer(bank.numCustomers()).getBankAccountWithIndex(0).deposit(500);
        bank.getCustomer(bank.numCustomers()).getBankAccountWithIndex(1).deposit(100);

        bank.addCustomer(new Customer("Amy","Cooper"));

        bank.getCustomer(bank.numCustomers()).addBankAccount(new BankAccount());
        bank.getCustomer(bank.numCustomers()).addBankAccount(new BankAccount());

        bank.getCustomer(bank.numCustomers()).getBankAccountWithIndex(0).deposit(400);
        bank.getCustomer(bank.numCustomers()).getBankAccountWithIndex(1).deposit(200);

        System.out.println((bank.getCustomer(1)));
        System.out.println((bank.getCustomer(2)));

        bank.printCustomersToFile("bank_customers.csv");
    }
}
