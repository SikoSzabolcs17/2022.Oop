package oop.labor10.lab10_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static oop.labor10.lab10_3.Product.naturalOrderingById;

public class Storage {
    private ArrayList<Product>products = new ArrayList<>();

    public Storage(String fileName){
        try(Scanner scanner = new Scanner(new File(fileName))){

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.isEmpty()){
                    continue;
                }
                String[] args = line.split(" ");

                products.add(new Product(Integer.parseInt(args[0].trim()),args[1].trim(),Integer.parseInt(args[2].trim()),Integer.parseInt(args[3].trim())));
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public void update(String fileName){

        products.sort(naturalOrderingById);

        try(Scanner scanner = new Scanner(new File(fileName))){

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.isEmpty()){
                    continue;
                }
                String[] args = line.split(" ");
                int id = Integer.parseInt(args[0].trim());
                int newAmount = Integer.parseInt(args[1].trim());

                int index = Collections.binarySearch(products,new Product(id,null,0,0),naturalOrderingById);

                if(index > 0){
                    products.get(index).increaseAmount(newAmount);
                }
                else{
                    products.add(-index-1,new Product(id,null,newAmount,0));
                    //System.out.println("New Product has been added - id:" + id );
                }
                //products.sort(naturalOrderingById);
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public void printAllProduct(){
        for (Product p:products){
            System.out.println(p);
        }
        System.out.println();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
