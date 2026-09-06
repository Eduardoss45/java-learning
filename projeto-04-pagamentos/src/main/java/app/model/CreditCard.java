package main.java.app.model;

public class CreditCard implements PaymentMethod {
    @Override
    public void process(double valor) {
        System.out.printf("Processando pagamento via Cartão de Crédito de R$ %.2f%n", valor);
    }

    @Override
    public String getName() {
        return "Cartão de Crédito";
    }
}