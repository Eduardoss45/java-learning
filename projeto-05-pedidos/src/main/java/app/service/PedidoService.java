package main.java.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import main.java.app.model.Order;
import main.java.app.model.OrderItem;
import main.java.app.model.OrderStatus;

public class PedidoService {
    private final List<Order> orders = new ArrayList<>();
    private int nextId = 1;

    public Order criarPedido(List<OrderItem> items) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("O pedido deve ter pelo menos um item.");
        }

        Order order = new Order(nextId++, items);
        orders.add(order);
        return order;
    }

    public void avancarStatus(int orderId) {
        Order order = buscarPorId(orderId);
        order.advanceStatus();
    }

    public void cancelarPedido(int orderId) {
        Order order = buscarPorId(orderId);
        order.cancel();
    }

    public List<Order> listarPorStatus(OrderStatus status) {
        return orders.stream().filter(o -> o.getStatus() == status).collect(Collectors.toList());
    }

    public List<Order> listarTodos() {
        return new ArrayList<>(orders);
    }

    private Order buscarPorId(int id) {
        return orders.stream().filter(o -> o.getId() == id).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado: #" + id));
    }
}
