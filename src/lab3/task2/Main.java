package lab3.task2;

import lab3.task1.shop.Product;
import lab3.task1.shop.Shop;
import lab3.task1.shop.Storage;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        FillStorage order = new FillStorage();
        Shop shop = new Shop("АТБ");
        shop.setStorage(new Storage());

        Product bread = new Product("Bread", 20);
        Product egg = new Product("Egg", 5);
        Product milk = new Product("Milk", 30);
        Product water = new Product("Boa o woa", 20);
        Product butter = new Product("Butter", 20);

        shop.storage.addSupplies(bread, 50);
        shop.storage.addSupplies(egg, 300);
        shop.storage.addSupplies(milk, 50);
        shop.storage.addSupplies(water,70);
        order.setStorage(shop.storage);

        HashMap<Product, Integer> arrivedProducts = new HashMap<>();
        arrivedProducts.put(bread, 200);
        arrivedProducts.put(egg, 500);
        arrivedProducts.put(milk, 50);
        arrivedProducts.put(water, 200);
        //arrivedProducts.put(butter, 20);

        System.out.println(order.getStorage());

        try {
            order.validate(arrivedProducts);
            System.out.println(order.getStorage());
        } catch (CustomException e){
            System.out.println(e.getMessage());
        }

    }
}
