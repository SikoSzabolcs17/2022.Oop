package oop.labor12.labor12_2;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage("data10000.txt");
        //storage.printAllProduct();

        System.out.println("Size:" + storage.getProducts().size());

        storage.update("update10000.txt");

        System.out.println("Size: " + storage.getProducts().size());

        //storage.printAllProduct();

    }
}
