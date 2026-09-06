package main.java.app.model;

public class Transfer implements PaymentMethod {
    @Override
    public void process(double valor) {
        System.out.printf("Processando pagamento via Transferência de R$ %.2f%n", valor);
    }

    @Override
    public String getName() {
        return "Transferência";
    }
}