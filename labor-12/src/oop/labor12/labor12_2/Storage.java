package oop.labor12.labor12_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static oop.labor12.labor12_2.Product.naturalOrderingById;

public class Storage {
    private HashMap<Integer,Product> products = new HashMap<>();

    public Storage(String fileName){
        try(Scanner scanner = new Scanner(new File(fileName))){

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.isEmpty()){
                    continue;
                }
                String[] args = line.split(" ");

                int id = 0;
                String name = "";
                int amount = 0;
                int price = 0;

                try{
                    id = Integer.parseInt(args[0].trim());
                    name = args[1].trim();
                    amount = Integer.parseInt(args[2].trim());
                    price = Integer.parseInt(args[3].trim());

                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
                products.put(id,new Product(id,name,amount,price));
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public void update(String fileName){

        Set<Integer>keys = products.keySet();

        try(Scanner scanner = new Scanner(new File(fileName))){

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.isEmpty()){
                    continue;
                }
                String[] args = line.split(" ");
                int id = Integer.parseInt(args[0].trim());
                int newAmount = Integer.parseInt(args[1].trim());

                if(keys.contains(id)){
                    products.get(id).increaseAmount(newAmount);
                }
                else{
                    products.put(id,new Product(id,null,newAmount,0));
                }
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public void printAllProduct(){
        for (Integer key:products.keySet()){
            System.out.println(products.get(key));
        }
        System.out.println();
    }

    public HashMap<Integer, Product> getProducts() {
        return products;
    }
}
