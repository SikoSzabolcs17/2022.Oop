package oop.labor10.lab10_3;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage("data1000.txt");
        //storage.printAllProduct();

        System.out.println("Size:" + storage.getProducts().size());

        storage.update("update1000.txt");

        System.out.println("Size: " + storage.getProducts().size());

        //storage.printAllProduct();

    }
}
