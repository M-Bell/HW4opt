package Product.Electronics;

import Product.AgeRestriction;

public class Appliance extends ElectronicsProduct {
    public Appliance(String name, double price, int quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction, 6);
    }

    @Override
    public double getPrice() {
        if (quantity < 50) {
            return -super.getPrice() * 0.05;
        }
        return super.getPrice();
    }
}
