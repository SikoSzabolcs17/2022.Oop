package oop.labor08.lab8_1.models;

public class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
    @Override
    public boolean withdraw(double value){
        if(balance + this.overdraftLimit>=value){
            if(balance<value){

                this.overdraftLimit = balance+overdraftLimit - value;
                balance = 0;
                return true;
            }
            else{
                balance -= value;
                return true;
            }
        }
        else return false;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "balance=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                ", overdraftLimit=" + overdraftLimit +
                '}';
    }
}
