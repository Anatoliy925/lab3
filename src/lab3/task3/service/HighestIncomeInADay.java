package lab3.task3.service;

import lab3.task1.shop.Check;
import lab3.task1.shop.Product;
import lab3.task1.shop.Shop;

import java.util.*;
import java.util.stream.Collectors;

public class HighestIncomeInADay {
    public static void getHighestIncome(Date date, Shop shop){
        ArrayList<Check> checks = new ArrayList<>();
        HashMap<Check, Integer> checksWithSum = new HashMap<>();
        shop.customers.stream().map((e) -> e.getHistory())
                .collect(Collectors.toList()).stream()
                .peek((checks1) ->
                        checks1.stream().filter((check) -> date.equals(check.getDate())))
                .forEach((checks2 -> checks2.forEach(check -> checks.add(check))));
        checks.stream().peek(check -> {
            checksWithSum.put(check, check.getSum());
        });
        Map.Entry<Check, Integer> maxEntry = null;
        for (Map.Entry<Check, Integer> entry : checksWithSum.entrySet())
        {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
            }
        }
        //System.out.println(maxEntry.getKey());
        System.out.println(checksWithSum);
    }
}
