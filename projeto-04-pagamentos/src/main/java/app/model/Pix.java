package main.java.app.model;

public class Pix implements PaymentMethod {
    @Override
    public void process(double valor) {
        System.out.printf("Processamento pagamento via PIX de R$ %.2f%n", valor);
    }

    @Override
    public String getName() {
        return "PIX";
    }
}