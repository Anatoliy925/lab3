package lab3.task3.service;

import lab3.task1.shop.Check;
import lab3.task1.shop.Customer;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SpendingsOverPeriodOfTime {
    public static List<Check> getSpendings(Customer customer, Date date1, Date date2){
        List<Check> result = customer.getHistory().stream()
                .filter((p)-> !(p.getDate().before(date1) || p.getDate().after(date2)))
                .collect(Collectors.toList());
        return result;
    }
}
