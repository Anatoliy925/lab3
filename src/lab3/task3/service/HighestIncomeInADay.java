package lab3.task3.service;

import lab3.task1.shop.Check;
import lab3.task1.shop.Product;
import lab3.task1.shop.Shop;

import java.util.*;
import java.util.stream.Collectors;

public class HighestIncomeInADay {
    public static void getHighestIncome(Date date, Shop shop){
        int max = shop.customers.stream()
                .flatMapToInt(customer -> customer.getHistory()
                        .stream().
                        filter(check -> check.getDate().equals(date)).
                        mapToInt(Check::getSum)).max().getAsInt();

        shop.customers.stream()
                .flatMap(customer -> customer.getHistory()
                        .stream().
                        filter(check -> check.getSum() == max && check.getDate().equals(date)))
                .forEach(System.out::println);
    }
}
