package main.java.app.model;

public interface PaymentMethod {
    void process(double valor);

    String getName();
}
