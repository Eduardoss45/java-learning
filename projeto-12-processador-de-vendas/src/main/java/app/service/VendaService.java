package main.java.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import main.java.app.model.Sale;

public class VendaService {
    private final List<Sale> sales = new ArrayList<>();

    public void registrar(String product, String customer, double value) {
        if (product == null || product.isBlank()) {
            throw new IllegalArgumentException("Produto não pode ser vazio.");
        }
        if (customer == null || customer.isBlank()) {
            throw new IllegalArgumentException("Cliente não pode ser vazio.");
        }
        if (value <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo.");
        }

        sales.add(new Sale(product, customer, value));
    }

    public List<Sale> filtrar(Predicate<Sale> criterio) {
        List<Sale> resultado = new ArrayList<>();

        for (Sale sale : sales) {
            if (criterio.test(sale)) {
                resultado.add(sale);
            }
        }

        return resultado;
    }

    public List<Sale> filtrarAcimaDe(double valorMinimo) {
        return filtrar(sale -> sale.getValue() > valorMinimo);
    }

    public Sale maiorVenda() {
        if (sales.isEmpty()) {
            throw new IllegalStateException("Nenhuma venda registrada.");
        }

        Sale maior = sales.get(0);
        for (Sale sale : sales) {
            if (sale.getValue() > maior.getValue()) {
                maior = sale;
            }
        }

        return maior;
    }

    public List<Sale> listarTodas() {
        return new ArrayList<>(sales);
    }

    public boolean estaVazio() {
        return sales.isEmpty();
    }
}