package Product.Electronics;

import Product.AgeRestriction;
import Product.Product;

public abstract class ElectronicsProduct extends Product {
    protected double guaranteePeriod;

    public ElectronicsProduct(String name, double price, int quantity, AgeRestriction ageRestriction, double guaranteePeriod) {
        super(name, price, quantity, ageRestriction);
        this.guaranteePeriod = guaranteePeriod;
    }
}
