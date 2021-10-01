package Product;

import Product.Interface.Buyable;

public abstract class Product implements Buyable {

    protected String name;
    protected double price;
    protected int quantity;
    protected AgeRestriction ageRestriction;

    public Product(String name, double price, int quantity, AgeRestriction ageRestriction) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.ageRestriction = ageRestriction;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Name = '" + name + '\'' +
                ", price = " + price +
                ", quantity = " + quantity +
                ", ageRestriction = " + ageRestriction +
                '}';
    }
}
