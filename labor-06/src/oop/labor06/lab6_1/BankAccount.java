package oop.labor06.lab6_1;


public class BankAccount {
    private double balance;
    private final String accountNumber;

    public static final String PREFIX = "OTP";

    private static int numAccounts = 0;

    private final int id;

    public static final int ACCOUNT_NUMBER_LENGTH = 10;


    public BankAccount() {
        this.id = ++numAccounts;
        this.accountNumber = createAccountNumber();

    }
    private static String createAccountNumber(){

        int zeros = ACCOUNT_NUMBER_LENGTH - PREFIX.length() - String.valueOf(numAccounts).length();
        return PREFIX + "0".repeat(zeros) + numAccounts;
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
        Account+= " account number, balance is: ";
        Account+=this.balance;
        Account+=" EUR.";
        return Account;

    }
}
