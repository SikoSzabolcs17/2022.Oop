package oop.labor03.lab3_1;

public class Customer {
    private String firstName;
    private String lastName;
    private BankAccount bankAccount = null;

    public Customer(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;


    }
    public void setBankAccount(BankAccount bankAccount){
        this.bankAccount = bankAccount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
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
    public void closeAccount() {
        this.bankAccount = null;
    }

    @Override
    public String toString() {
        if(bankAccount == null) {
            return this.firstName + " " + this.lastName + "\n No BankAccount";
        }
        else return this.firstName + " " + this.lastName + "\n " + bankAccount.toString();

    }

}
