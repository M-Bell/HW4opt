import Customer.Customer;
import Exceptions.AgeRestrictionException;
import Exceptions.InsufficientCostsException;
import Exceptions.NotEnoughProductException;
import Exceptions.ProductExpiredException;
import Product.FoodProduct;
import Product.Product;

public class PurchaseManager {
    public static void processPurchase(Product product, Customer customer) throws AgeRestrictionException, NotEnoughProductException, ProductExpiredException, InsufficientCostsException {
        if (customer.getAge() < product.getAgeRestriction().getAge()) {
            throw new AgeRestrictionException();
        }
        if (product.getQuantity() <= 0) {

            throw new NotEnoughProductException();
        }
        if (product.getClass().equals(FoodProduct.class) && ((FoodProduct) product).getDaysDiff() <= 0) {

            throw new ProductExpiredException();
        }

        if (customer.getBalance() < product.getPrice()) {
            throw new InsufficientCostsException();
        }
        product.setQuantity(product.getQuantity() - 1);
        customer.setBalance(customer.getBalance() - product.getPrice());
        System.out.println("Purchase was successful!");
    }
}
