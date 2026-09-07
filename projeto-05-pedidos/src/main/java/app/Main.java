package main.java.app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import main.java.app.model.Order;
import main.java.app.model.OrderItem;
import main.java.app.model.OrderStatus;
import main.java.app.service.PedidoService;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            PedidoService service = new PedidoService();
            int opcao = -1;

            do {
                System.out.println("\n===== SISTEMA DE PEDIDOS =====");
                System.out.println("1. Criar pedido");
                System.out.println("2. Avançar status do pedido");
                System.out.println("3. Listar pedidos por status");
                System.out.println("0. Sair");
                System.out.print("Escolha: ");

                try {
                    opcao = sc.nextInt();
                    sc.nextLine();

                    switch (opcao) {
                        case 1 -> criarPedido(sc, service);
                        case 2 -> avancarStatus(sc, service);
                        case 3 -> listarPorStatus(sc, service);
                        case 0 -> System.out.println("Saindo...");
                        default -> System.out.println("Opção inválida!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Erro: Digite apenas números.");
                    sc.nextLine();
                    opcao = -1;
                } catch (IllegalArgumentException | IllegalStateException e) {
                    System.out.println("Erro: " + e.getMessage());
                }

            } while (opcao != 0);
        }
    }

    private static void criarPedido(Scanner sc, PedidoService service) {
        List<OrderItem> items = new ArrayList<>();

        System.out.print("Quantos itens no pedido? ");
        int qtdItens = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= qtdItens; i++) {
            System.out.print("Produto " + i + ": ");
            String product = sc.nextLine();

            System.out.print("Quantidade: ");
            int qty = sc.nextInt();
            sc.nextLine();

            items.add(new OrderItem(product, qty));
        }

        Order order = service.criarPedido(items);
        System.out.println("Pedido criado com sucesso!");
        System.out.println(order);
    }

    private static void avancarStatus(Scanner sc, PedidoService service) {
        System.out.print("ID do pedido: ");
        int id = sc.nextInt();
        sc.nextLine();

        service.avancarStatus(id);
        System.out.println("Status avançado com sucesso!");
    }

    private static void listarPorStatus(Scanner sc, PedidoService service) {
        System.out.println("Escolha o status:");
        OrderStatus[] statuses = OrderStatus.values();
        for (int i = 0; i < statuses.length; i++) {
            System.out.println(i + " - " + statuses[i]);
        }

        System.out.print("Opção: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index < 0 || index >= statuses.length) {
            throw new IllegalArgumentException("Status inválido.");
        }

        OrderStatus status = statuses[index];
        List<Order> pedidos = service.listarPorStatus(status);

        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido com status " + status);
        } else {
            System.out.println("=== Pedidos com status " + status + " ===");
            pedidos.forEach(System.out::println);
        }
    }
}