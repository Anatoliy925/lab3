package lab3.task3.service;

import lab3.task1.shop.Product;
import lab3.task1.shop.Storage;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.*;

public class FilterAndSort {
    public static Map<Product, Integer> filterByQuantity(Storage storage, Integer quantity){
        Map<Product, Integer> result = storage.getSupplies().entrySet()
                .stream()
                .filter(map -> quantity.equals(map.getValue()))
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
        return result;
    }
    public static HashMap<Product, Integer> sortByQuantity(Storage storage) {
        HashMap<Product, Integer> temp = storage.getSupplies().entrySet()
                .stream()
                .sorted(Comparator.comparing(Entry::getValue))
                .collect(Collectors.toMap(
                        Entry::getKey,
                        Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        return temp;
    }
}
