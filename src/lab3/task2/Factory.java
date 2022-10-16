package lab3.task2;

import lab3.task1.shop.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Factory {
    private HashMap<Product, Integer> supplies;

    public ArrayList<Product> getAssortment(){
        ArrayList<Product> result = new ArrayList<>();
        for (Product product : supplies.keySet()) {
            result.add(product);
        }
        return result;
    }

}
