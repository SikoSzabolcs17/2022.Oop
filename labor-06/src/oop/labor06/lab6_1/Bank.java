package oop.labor06.lab6_1;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Bank {
    private final String name;
    ArrayList<Customer>customers;

    public Bank(String name) {
        customers = new ArrayList<>();
        this.name = name;
    }

    public Customer getCustomer(int customerID) {
        for(Customer customer:customers){
            if(customer.getId() == customerID){
                return customer;
            }
        }
        return null;
    }
    private void printCustomers( PrintStream ps){

        ps.println("ID, Firstname, Last name, Number of bank accounts:");

        for( Customer customer: customers ){
            ps.println( customer.getId()+", " + customer.getFirstName() +", "+
                    customer.getLastName()+", "+customer.getNumAccounts());
        }
        ps.close();
    }
    public void printCustomersToStdout() {
        printCustomers(System.out);
    }
    public void printCustomersToFile( String filename ){
        try(PrintStream printStream = new PrintStream(filename)){

            printCustomers( printStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void addCustomer(Customer customer){
        this.customers.add(customer);
    }
    public int numCustomers(){
        return this.customers.size();
    }
}
