package lab3.task1.shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Shop {
    private final String name;
    public Storage storage;
    public ArrayList<Customer> customers;
    private Date date;

    public Shop(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void sell(Customer customer, HashMap<Product, Integer> basket){
        for (Product product: basket.keySet()){
            storage.removeSupplies(product, basket.get(product));
        }
        Check check = new Check(basket, date);
        customer.addCheck(check);
    }



}
