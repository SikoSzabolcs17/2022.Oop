package oop.labor10.lab10_3;

import java.util.Comparator;

public class Product {
    private final int id;
    private final String name;
    private int amount;
    private final int price;

    public static Comparator<Product> naturalOrderingById = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return o1.getId() - o2.getId();
        }
    };

    public Product(int id, String name, int amount, int price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
    public void increaseAmount(int newAmount){
        this.amount = newAmount;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
