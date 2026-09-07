package main.java.app.service;

import java.util.ArrayList;
import java.util.List;

import main.java.app.model.Product;

public class CatalogoService {
    private final List<Product> products = new ArrayList<>();
    private int nextId = 1;

    public Product adicionar(String name, double price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nome do produto não pode ser vazio.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo.");
        }

        Product product = new Product(nextId++, name, price);
        products.add(product);
        return product;
    }

    public boolean removerPorNome(String name) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equalsIgnoreCase(name)) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    public Product buscarPorNome(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> listarTodos() {
        return new ArrayList<>(products);
    }

    public boolean estaVazio() {
        return products.isEmpty();
    }
}