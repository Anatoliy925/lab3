package lab3.task1.shop;

public class Product {
    private final String name;
    private final int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " $" + price + " ";
    }

    public int getPrice() {
        return price;
    }
}
