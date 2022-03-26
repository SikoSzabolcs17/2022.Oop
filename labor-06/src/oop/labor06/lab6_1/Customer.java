package oop.labor06.lab6_1;

import oop.labor06.lab6_1.BankAccount;

import java.util.ArrayList;


public class Customer {
    private final String firstName;
    private String lastName;
    private final int id;
    private static int numCustomers = 0;

    private ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    public Customer(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = ++numCustomers;

    }
    public void addBankAccount(BankAccount bankAccount){

        bankAccounts.add(bankAccount);
    }

    public int getId() {
        return id;
    }

    public static int getNumCustomers() {
        return numCustomers;
    }

    public BankAccount getBankAccount(String accountNumber) {
        for (int i = 0; i < bankAccounts.size(); i++) {

            if(accountNumber.equals(bankAccounts.get(i).getAccountNumber())){
                return bankAccounts.get(i);
            }
        }
        return null;
    }
    public BankAccount getBankAccountWithIndex(int index) {
        if(bankAccounts.size() >= index){
            return bankAccounts.get(index);
        }
        return null;
    }
    public String getBankAccountNumberWithIndex(int index){
        if(index<=this.bankAccounts.size()){
            return this.bankAccounts.get(index).getAccountNumber();
        }
        return null;
    }
    public ArrayList<String> getAccountNumbers(){
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < bankAccounts.size(); i++) {
            arrayList.add(bankAccounts.get(i).getAccountNumber());
        }
        return arrayList;
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
        result.append("ID:" + id + " ");
        result.append(firstName + ' ' + lastName + " accounts:\n");

        for(int i=0; i<bankAccounts.size(); ++i){

            result.append( "\t" + bankAccounts.get(i).toString() +"\n");
        }
        return result.toString();
    }
}
