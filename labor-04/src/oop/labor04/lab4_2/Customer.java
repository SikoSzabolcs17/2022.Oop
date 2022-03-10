package oop.labor04.lab4_2;

import java.util.ArrayList;


public class Customer {
    private final String firstName;
    private String lastName;

    private ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    public Customer(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

    }
    public void addBankAccount(BankAccount bankAccount){

        bankAccounts.add(bankAccount);
    }

    public BankAccount getBankAccount(String accountNumber) {
        for (int i = 0; i < bankAccounts.size(); i++) {

            if(accountNumber.equals(bankAccounts.get(i).getAccountNumber())){
                return bankAccounts.get(i);
            }
        }
        return null;
    }
    public String getBankAccountNumberWithIndex(int index){
        if(index<=this.bankAccounts.size()){
            return this.bankAccounts.get(index).getAccountNumber();
        }
        return null;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void closeAccount(String accountNumber) {

        for (int i = 0; i < bankAccounts.size(); i++) {
            if(accountNumber.equals(bankAccounts.get(i).getAccountNumber())){
                bankAccounts.remove(i);
                return;
            }
        }
        System.out.println("Someting is wrong with the account number! Cannot close if not existing!");
    }

    public int getNumAccounts() {
        return bankAccounts.size();
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(firstName + ' ' + lastName + " accounts:\n");

        for(int i=0; i<bankAccounts.size(); ++i){

            result.append( "\t" + bankAccounts.get(i).toString() +"\n");
        }
        return result.toString();
    }
}
