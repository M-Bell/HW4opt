import Customer.Customer;
import Exceptions.AgeRestrictionException;
import Exceptions.InsufficientCostsException;
import Exceptions.NotEnoughProductException;
import Exceptions.ProductExpiredException;
import Product.AgeRestriction;
import Product.Electronics.Appliance;
import Product.Electronics.Computer;
import Product.FoodProduct;
import Product.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Tester {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        FoodProduct cigars = new FoodProduct("420 Blaze it fgt", 6.90, 1400, AgeRestriction.ADULT);
        FoodProduct apples = new FoodProduct("Green apple", 2.30, 100, AgeRestriction.NONE);
        FoodProduct energetic = new FoodProduct("Red Bull", 12.90, 1200, AgeRestriction.TEENAGER);
        FoodProduct beer = new FoodProduct("Bud", 21.20, 1000, AgeRestriction.ADULT);
        Appliance lamp = new Appliance("Lamp", 210.20, 800, AgeRestriction.NONE);
        Appliance clock = new Appliance("Clock", 100.20, 200, AgeRestriction.NONE);
        Computer mac = new Computer("Mac", 32100.99, 700, AgeRestriction.ADULT);
        products.add(cigars);
        products.add(apples);
        products.add(energetic);
        products.add(beer);
        products.add(lamp);
        products.add(clock);
        products.add(mac);
        Customer pecata = new Customer("Pecata", 17, 30.00);
        validatedPurchase(cigars, pecata);
        Customer gopeto = new Customer("Gopeto", 18, 20);
        validatedPurchase(cigars, gopeto);
        Customer rich = new Customer("Richie", 22, 40000);

        validatedPurchase(cigars, gopeto);
        validatedPurchase(mac, rich);
        validatedPurchase(mac, rich);
        getSoonestExpirable(products);
        getAdultPriceList(products);

    }

    public static void validatedPurchase(Product product, Customer customer) {
        try {
            PurchaseManager.processPurchase(product, customer);
        } catch (AgeRestrictionException e) {
            System.out.println("You are too young to buy this!");
        } catch (NotEnoughProductException e) {
            System.out.println("There is no such product left!");
        } catch (ProductExpiredException e) {
            System.out.println("This product expired!");
        } catch (InsufficientCostsException e) {
            System.out.println("Not enough money!");
        }
    }

    public static void getSoonestExpirable(ArrayList<Product> products) {
        List<Product> expirableProduct = products.stream().filter(x -> x.getClass().equals(FoodProduct.class)).sorted(Comparator.comparingLong(x -> ((FoodProduct) x).getDaysDiff())).collect(Collectors.toList());
        if (expirableProduct.size() <= 0) {
            System.out.println("No expirable products");
            return;
        }
        Product product = expirableProduct.get(0);
        System.out.println(product.getName() + " expires in " + ((FoodProduct) product).getDaysDiff() + " days");
    }

    public static void getAdultPriceList(ArrayList<Product> products) {
        List<Product> adultPriceList = products.stream().filter(x -> x.getAgeRestriction().equals(AgeRestriction.ADULT)).sorted(Comparator.comparingDouble(Product::getPrice)).collect(Collectors.toList());
        if (adultPriceList.size() <= 0) {
            System.out.println("No adult products");
            return;
        }
        for (Product a : adultPriceList) {
            System.out.println(a);
        }
    }
}
