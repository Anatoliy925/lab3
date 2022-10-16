package lab3.task3;

import lab3.task1.shop.Customer;
import lab3.task1.shop.Product;
import lab3.task1.shop.Shop;
import lab3.task1.shop.Storage;
import lab3.task3.service.*;

import java.util.Date;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop("АТБ");
        shop.setStorage(new Storage());
        Date day1 = new Date(2022, 10, 10);
        Date day2 = new Date(2022, 10, 11);
        Date day3 = new Date(2022, 10, 12);
        shop.setDate(day1);

        Customer jonSnow = new Customer("Jon", "Snow");
        Customer samTarly = new Customer("Sam", "Tarly");
        Customer robbStark = new Customer("Robb", "Stark");

        Product bread = new Product("Bread", 20);
        Product egg = new Product("Egg", 5);
        Product milk = new Product("Milk", 30);
        Product water = new Product("Boa o woa", 20);

        shop.storage.addSupplies(bread, 50);
        shop.storage.addSupplies(egg, 300);
        shop.storage.addSupplies(milk, 50);
        shop.storage.addSupplies(water,70);

        HashMap<Product, Integer> jonsBasket = new HashMap<>();
        HashMap<Product, Integer> samsBasket = new HashMap<>();
        HashMap<Product, Integer> robbsBasket = new HashMap<>();

        jonsBasket.put(bread, 2);
        jonsBasket.put(water, 5);
        samsBasket.put(milk, 3);
        samsBasket.put(egg, 20);
        samsBasket.put(water, 1);
        robbsBasket.put(bread, 1);

        shop.customers.add(jonSnow);
        shop.customers.add(samTarly);
        shop.customers.add(robbStark);

        shop.sell(jonSnow, jonsBasket);
        shop.sell(samTarly, samsBasket);
        shop.sell(robbStark, robbsBasket);

        shop.setDate(day2);
        shop.sell(jonSnow, samsBasket);
        shop.sell(robbStark, jonsBasket);

        System.out.println("Average price of products in the storage: " + AveragePrice.getAveragePriceOfAllProducts(shop.storage));
        System.out.println("Filtering storage by quantity: " + FilterAndSort.filterByQuantity(shop.storage, 280));
        System.out.println("Most popular product: " + MostPopularProduct.getMostPopularProduct(shop));
        System.out.println("Highest income in a day: ");
        HighestIncomeInADay.getHighestIncome(day1, shop);
        System.out.println("Jon's summary of purchases: " + SummaryOfPurchases.getSummary(jonSnow));
        System.out.println("Purchases from 10.10.2022 to 12.10.2022 by Jon: " + "\n" +
                SpendingsOverPeriodOfTime.getSpendings(jonSnow, day1, day3));
    }
}
