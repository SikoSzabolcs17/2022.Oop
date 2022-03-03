package oop.labor03.lab3_1;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("John", "BLACK");
        System.out.println(customer1);

        customer1.setBankAccount(new BankAccount("OTP00001"));

        customer1.getBankAccount().deposit(1000);

        System.out.println(customer1.getBankAccount().getBalance());

        Customer customer2 = new Customer("Mary","WHITE");

        customer2.setBankAccount(new BankAccount("OTP00002"));

        customer2.getBankAccount().deposit(2000);
        customer2.getBankAccount().withdraw(250);

        customer2.closeAccount();

        System.out.println(customer2);

        customer2.setLastName(customer1.getLastName());
        customer2.setBankAccount(customer1.getBankAccount());

        System.out.println(customer1);
        System.out.println(customer2);


    }
}
