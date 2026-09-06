package main.java.app.model;

public class Payment {
    private PaymentMethod method;
    private double value;

    public Payment(PaymentMethod method, double value) {
        this.method = method;
        this.value = value;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("Pagamento | Método: %s | Valor: R$ %.2f", method.getName(), value);
    }
}