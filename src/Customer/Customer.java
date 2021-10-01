package Customer;

public class Customer {
    private final String name;
    private int age;
    private double balance;

    public Customer(String name, int age, double balance) {
        this.name = name;
        setAge(age);
        this.balance = balance;
    }

    public void setAge(int age) {
        if(age < 0) this.age = 0;
        this.age = age;
    }

    public void setBalance(double balance) {
        if(balance < 0) this.balance = 0;
        this.balance = balance;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }
}
