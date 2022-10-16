package lab3.task3.service;

import lab3.task1.shop.Product;
import lab3.task1.shop.Shop;
import lab3.task1.shop.Storage;

import java.util.Comparator;
import java.util.HashMap;
import java.util.*;
import java.util.stream.Collectors;

public class MostPopularProduct {
    public static HashMap<Product, Integer> getMostPopularProduct(Shop shop){
        HashMap<Product, Integer> result = new HashMap<>();
        shop.customers.stream().map((e) -> e.getHistory())
                .collect(Collectors.toList()).stream()
                .forEach((e) -> {
                    e.stream().map((a) -> a.getProducts())
                            .collect(Collectors.toList()).stream()
                            .forEach(
                                    (b) -> {
                                        b.forEach((key, value) -> result.merge(key, value, Integer::sum));
                                    }
                            );
                });

        Map.Entry<Product, Integer> maxEntry = null;
        for (Map.Entry<Product, Integer> entry : result.entrySet())
        {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
            }
        }
        result.clear();
        result.put(maxEntry.getKey(), maxEntry.getValue());
        return result;
    }
}
