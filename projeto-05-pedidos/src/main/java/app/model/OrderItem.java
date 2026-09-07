package main.java.app.model;

public record OrderItem(String product, int quantity) {
    public OrderItem {
        if (product == null || product.isBlank()) {
            throw new IllegalArgumentException("Produto não pode ser vazio.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser positiva.");
        }
    }

    @Override
    public String toString() {
        return String.format("%s (x%d)", product, quantity);
    }
}