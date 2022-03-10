package oop.labor04.lab4_2;


public class BankAccount {
    private double balance;
    private final String accountNumber;

    public BankAccount(String accountNumber){
        balance=0;
        this.accountNumber = accountNumber;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public double getBalance(){
        return balance;
    }

    public void deposit(double value){
        if(value > 0){
            balance += value;
        }
    }
    public boolean withdraw(double value){
        if(balance>=value){
            balance -= value;
            return true;
        }
        else return false;
    }
    @Override
    public String toString(){
        String Account = this.accountNumber;
        Account+= " account number, your balance is: ";
        Account+=this.balance;
        Account+=" EUR.";
        return Account;

    }
}
