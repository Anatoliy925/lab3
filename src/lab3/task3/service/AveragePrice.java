package lab3.task3.service;

import lab3.task1.shop.Storage;

import java.util.stream.Collectors;

public class AveragePrice {
    public static double getAveragePriceOfAllProducts(Storage storage){
        double average = storage.getAssortment().stream().map((e) -> e.getPrice()).
                collect(Collectors.toList()).stream().mapToDouble(Integer::doubleValue).average().getAsDouble();
        return average;
    }
}
