package lab3.task1.shop;

import java.util.ArrayList;
import java.util.HashMap;

public class Storage {
    private HashMap<Product, Integer> supplies;

    public void addSupplies(Product product, Integer quantity){
        if (supplies.containsKey(product)){
            supplies.put(product, supplies.get(product) + quantity);
        } else {
            supplies.put(product, quantity);
        }
    }

    public void removeSupplies(Product product, Integer quantity){
        if (!supplies.containsKey(product)) return;
        if (quantity > supplies.get(product)) return;
        if (supplies.containsKey(product)){
            supplies.put(product, supplies.get(product) - quantity);
        }
    }

    public HashMap<Product, Integer> getSupplies() {
        return supplies;
    }

    public Storage() {
        this.supplies = new HashMap<>();
    }

    public ArrayList<Product> getAssortment(){
        ArrayList<Product> result = new ArrayList<>();
        for (Product product : getSupplies().keySet()) {
            result.add(product);
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "Storage: \n";
        for (Product product: supplies.keySet()) {
            String key = product.toString();
            String value = supplies.get(product).toString();
            result += key + " x" + value + "\n";
        }
        return result;
    }
}
