package oop.labor03.lab3_2;
import oop.labor03.lab3_1.BankAccount;

public class Customer {
    private String firstName;
    private String lastName;

    public static final int MAX_ACCOUNTS = 10;

    private int numAccounts;
    private BankAccount[] bankAccounts = new BankAccount[ MAX_ACCOUNTS ];

    public Customer(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;


    }
    public void addBankAccount(BankAccount bankAccount){

        if(this.numAccounts < MAX_ACCOUNTS) {
            this.bankAccounts[numAccounts++] = bankAccount;
        }
    }

    public BankAccount getBankAccount(String accountNumber) {
        for (int i = 0; i < numAccounts; i++) {
            if(accountNumber.equals(bankAccounts[i].getAccountNumber())){
                return bankAccounts[i];
            }
        }
        return null;
    }
    public String bankAccountNumberWithIndex(int index){
        if(index<=this.numAccounts){
            return this.bankAccounts[index].getAccountNumber();
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

        for (int i = 0; i < this.numAccounts; i++) {

            if(bankAccounts[i].getAccountNumber().equals(accountNumber)){
                for (int j = i; j < numAccounts-1 ; j++) {
                    bankAccounts[j] = bankAccounts[j+1];
                }
                bankAccounts[numAccounts-1] = null;
                numAccounts--;
                return;
            }
        }
        System.out.println("Someting is wrong with the account number!");
    }

    public int getNumAccounts() {
        return numAccounts;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(firstName + ' ' + lastName + " accounts:\n");
        for(int i=0; i<numAccounts; ++i){
            result.append( "\t" + bankAccounts[i].toString() +"\n");
        }
        return result.toString();
    }
}
