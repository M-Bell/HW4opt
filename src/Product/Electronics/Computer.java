package Product.Electronics;

import Product.AgeRestriction;

public class Computer extends ElectronicsProduct {
    public Computer(String name, double price, int quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction, 24);
    }

    @Override
    public double getPrice() {
        if (quantity > 1000) return super.getPrice() * 0.05;
        return super.getPrice();
    }
}
