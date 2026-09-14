package main.java.app;

import main.java.app.model.Sale;
import main.java.app.service.VendaService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            VendaService service = new VendaService();
            int opcao = -1;

            do {
                System.out.println("\n===== PROCESSADOR DE VENDAS =====");
                System.out.println("1. Registrar venda");
                System.out.println("2. Filtrar vendas acima de um valor");
                System.out.println("3. Encontrar maior venda");
                System.out.println("4. Listar vendas");
                System.out.println("0. Sair");
                System.out.print("Escolha: ");

                try {
                    opcao = sc.nextInt();
                    sc.nextLine();

                    switch (opcao) {
                        case 1 -> registrar(sc, service);
                        case 2 -> filtrar(sc, service);
                        case 3 -> maiorVenda(service);
                        case 4 -> listar(service);
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

    private static void registrar(Scanner sc, VendaService service) {
        System.out.print("Produto: ");
        String product = sc.nextLine();

        System.out.print("Cliente: ");
        String customer = sc.nextLine();

        System.out.print("Valor: ");
        double value = sc.nextDouble();
        sc.nextLine();

        service.registrar(product, customer, value);
        System.out.println("Venda registrada com sucesso!");
    }

    private static void filtrar(Scanner sc, VendaService service) {
        System.out.print("Valor mínimo: ");
        double minimo = sc.nextDouble();
        sc.nextLine();

        List<Sale> filtradas = service.filtrarAcimaDe(minimo);

        if (filtradas.isEmpty()) {
            System.out.println("Nenhuma venda acima de R$ " + minimo);
        } else {
            System.out.println("=== Vendas acima de R$ " + minimo + " ===");
            filtradas.forEach(System.out::println);
        }
    }

    private static void maiorVenda(VendaService service) {
        Sale maior = service.maiorVenda();
        System.out.println("Maior venda: " + maior);
    }

    private static void listar(VendaService service) {
        List<Sale> todas = service.listarTodas();

        if (todas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            System.out.println("=== Todas as Vendas ===");
            todas.forEach(System.out::println);
        }
    }
}