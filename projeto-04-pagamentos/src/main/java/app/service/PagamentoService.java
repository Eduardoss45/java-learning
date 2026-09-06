package main.java.app.service;

import java.util.ArrayList;
import java.util.List;

import main.java.app.model.Payment;
import main.java.app.model.PaymentMethod;

public class PagamentoService {
    private final List<PaymentMethod> methods = new ArrayList<>();

    private final List<Payment> processedPayments = new ArrayList<>();

    public void cadastrarMetodo(PaymentMethod method) {
        methods.add(method);
    }

    public List<PaymentMethod> listarMetodos() {
        return new ArrayList<>(methods);
    }

    public void processarPagameto(int index, double valor) {
        if (index < 0 || index >= methods.size()) {
            throw new IllegalArgumentException("Método de pagamento inválido.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo.");
        }

        PaymentMethod method = methods.get(index);
        method.process(valor);

        processedPayments.add(new Payment(method, valor));
    }

    public List<Payment> listarPagamentosProcessados() {
        return new ArrayList<>(processedPayments);
    }
}
