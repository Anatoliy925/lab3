package lab3.task3.service;

import lab3.task1.shop.Customer;
import lab3.task1.shop.Product;

import java.util.HashMap;
import java.util.stream.Collectors;

public class SummaryOfPurchases {
    public static HashMap<Product, Integer> getSummary(Customer customer){
        HashMap<Product, Integer> result = new HashMap<>();
        customer.getHistory().stream()
                .map((e) -> e.getProducts())
                .collect(Collectors.toList()).stream()
                .forEach(
                        (e) -> {
                            e.forEach((key, value) -> result.merge(key, value, Integer::sum));
                        }
                );
        return result;
    }
}
