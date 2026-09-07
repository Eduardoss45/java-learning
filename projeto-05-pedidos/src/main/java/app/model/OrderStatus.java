package main.java.app.model;

public enum OrderStatus {
    CREATED,
    PAID,
    SHIPPED,
    DELIVERED,
    CANCELLED;

    public OrderStatus next() {
        return switch (this) {
            case CREATED -> PAID;
            case PAID -> SHIPPED;
            case SHIPPED -> DELIVERED;
            case DELIVERED, CANCELLED -> throw new IllegalArgumentException("Não é possível avançar o status: " + this);
        };
    }

    public boolean canCancel() {
        return this == CREATED || this == PAID;
    }
}