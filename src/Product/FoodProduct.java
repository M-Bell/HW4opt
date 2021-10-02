package Product;

import Product.Interface.Expirable;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class FoodProduct extends Product implements Expirable {
    private Date expDate;
    private long daysDiff;

    public FoodProduct(String name, double price, int quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction);
        expDate = getExpirationDate();
        daysDiff = TimeUnit.MILLISECONDS.toDays(expDate.getTime()) - TimeUnit.MILLISECONDS.toDays(Calendar.getInstance().getTime().getTime());
    }

    @Override
    public double getPrice() {
        if (daysDiff < 15)
            return super.getPrice() * 0.3;
        return super.getPrice();
    }

    @Override
    public Date getExpirationDate() {
        Random rnd = new Random();
        int month = rnd.nextInt(2) + 9;
        int day = rnd.nextInt(25) + 4;
        Calendar cal = Calendar.getInstance();
        cal.set(2021, month, day);
        return cal.getTime();
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
        daysDiff = TimeUnit.MILLISECONDS.toDays(expDate.getTime()) - TimeUnit.MILLISECONDS.toDays(Calendar.getInstance().getTime().getTime());
    }

    public int getDaysDiff() {
        return (int) daysDiff;
    }
}
