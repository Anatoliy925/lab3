package lab3.task1;

import lab3.task1.shop.Customer;
import lab3.task1.shop.Product;
import lab3.task1.shop.Shop;
import lab3.task1.shop.Storage;


import java.util.Date;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop("АТБ");
        shop.setStorage(new Storage());
        shop.setDate(new Date(2022, 10, 10));

        Product bread = new Product("Bread", 20);
        Product egg = new Product("Egg", 5);
        Product milk = new Product("Milk", 30);
        Product water = new Product("Boa o woa", 20);

        shop.storage.addSupplies(bread, 50);
        shop.storage.addSupplies(egg, 300);
        shop.storage.addSupplies(milk, 50);
        shop.storage.addSupplies(water,70);

        Customer jonSnow = new Customer("Jon", "Snow");
        Customer samTarly = new Customer("Sam", "Tarly");
        Customer robbStark = new Customer("Robb", "Stark");

        HashMap<Product, Integer> jonsBasket = new HashMap<>();
        HashMap<Product, Integer> samsBasket = new HashMap<>();
        HashMap<Product, Integer> robbsBasket = new HashMap<>();

        jonsBasket.put(bread, 2);
        jonsBasket.put(water, 5);
        samsBasket.put(milk, 3);
        samsBasket.put(egg, 20);
        samsBasket.put(water, 1);
        robbsBasket.put(bread, 1);

        System.out.println(shop.storage);

        shop.customers.add(jonSnow);
        shop.customers.add(samTarly);
        shop.customers.add(robbStark);

        shop.sell(jonSnow, jonsBasket);
        shop.sell(samTarly, samsBasket);
        shop.sell(robbStark, robbsBasket);

        jonSnow.printHistory();
        samTarly.printHistory();
        robbStark.printHistory();

        System.out.println(shop.storage);
    }

}
