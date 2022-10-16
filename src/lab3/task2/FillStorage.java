package lab3.task2;

import lab3.task1.shop.Product;
import lab3.task1.shop.Storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FillStorage {
    private Storage storage;

    public void validate(HashMap<Product, Integer> arrivedProducts) throws CustomException{
        ArrayList<Product> arrivedAssortment = new ArrayList<Product>(arrivedProducts.keySet());
        ArrayList<Product> shopAssortment = new ArrayList<Product>(storage.getAssortment());

        for (Product product : arrivedAssortment){
            if (shopAssortment.contains(product)){
                storage.addSupplies(product, arrivedProducts.get(product));
            } else {
                throw new CustomException("We don't sell this type of product here!");
            }
        }
        System.out.println("Validated!!!");
    }

    public void receiveProducts(HashMap<Product, Integer> products){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product key = entry.getKey();
            Integer value = entry.getValue();
            storage.addSupplies(key, value);
        }
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Storage getStorage() {
        return storage;
    }

    public FillStorage() {
        this.storage = new Storage();
    }
}
