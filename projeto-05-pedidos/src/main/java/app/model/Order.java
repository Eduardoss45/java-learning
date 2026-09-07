package main.java.app.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int id;
    private final List<OrderItem> items;
    private OrderStatus status;

    public Order(int id, List<OrderItem> items) {
        this.id = id;
        this.items = new ArrayList<>(items);
        this.status = OrderStatus.CREATED;
    }

    public int getId() {
        return id;
    }

    public List<OrderItem> getItems() {
        return new ArrayList<>(items);
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void advanceStatus() {
        this.status = this.status.next();
    }

    public void cancel() {
        if (!status.canCancel()) {
            throw new IllegalStateException("Não é possível cancelar um pedido com status: " + status);
        }
        this.status = OrderStatus.CANCELLED;
    }

    @Override
    public String toString() {
        return String.format("Pedido #%d | Status: %s | Itens: %s", id, status, items);
    }
}