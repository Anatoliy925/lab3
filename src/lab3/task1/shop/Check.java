package lab3.task1.shop;

import java.util.Date;
import java.util.HashMap;

public class Check {
    private HashMap<Product, Integer> products;
    private final Date date;

    public Check(HashMap<Product, Integer> products, Date date) {
        this.products = products;
        this.date = date;
    }

    @Override
    public String toString() {
        String result = date.toString().substring(0, 10) + ": \n";
        for (Product product: products.keySet()) {
            String key = product.toString();
            String value = products.get(product).toString();
            result += key + " x" + value + "\n";
        }
        result += "Sum: " + getSum() +" $"+ "\n";
        return result;
    }

    public Date getDate() {
        return date;
    }

    public HashMap<Product, Integer> getProducts() {
        return products;
    }
    public int getSum(){
        int sum = 0;
        for (Product product : products.keySet()) {
            sum += product.getPrice()*products.get(product);
        }
        return sum;
    }
}
