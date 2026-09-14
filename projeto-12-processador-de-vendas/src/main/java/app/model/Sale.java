package main.java.app.model;

public class Sale {
    private final String product;
    private final String customer;
    private final double value;

    public Sale(String product, String customer, double value) {
        this.product = product;
        this.customer = customer;
        this.value = value;
    }

    public String getProduct() {
        return product;
    }

    public String getCustomer() {
        return customer;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("%s | Cliente: %s | R$ %.2f", product, customer, value);
    }
}
