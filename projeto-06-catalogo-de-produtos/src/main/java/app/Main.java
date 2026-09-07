package main.java.app;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import main.java.app.model.Product;
import main.java.app.service.CatalogoService;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            CatalogoService service = new CatalogoService();
            int opcao = -1;

            do {
                System.out.println("\n===== CATÁLOGO DE PRODUTOS =====");
                System.out.println("1. Adicionar produto");
                System.out.println("2. Remover produto");
                System.out.println("3. Buscar produto por nome");
                System.out.println("4. Listar todos");
                System.out.println("0. Sair");
                System.out.print("Escolha: ");

                try {
                    opcao = sc.nextInt();
                    sc.nextLine();

                    switch (opcao) {
                        case 1 -> adicionar(sc, service);
                        case 2 -> remover(sc, service);
                        case 3 -> buscar(sc, service);
                        case 4 -> listar(service);
                        case 0 -> System.out.println("Saindo...");
                        default -> System.out.println("Opção inválida!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Erro: Digite apenas números.");
                    sc.nextLine();
                    opcao = -1;
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                }

            } while (opcao != 0);
        }
    }

    private static void adicionar(Scanner sc, CatalogoService service) {
        System.out.print("Nome do produto: ");
        String name = sc.nextLine();

        System.out.print("Preço: ");
        double price = sc.nextDouble();
        sc.nextLine();

        Product product = service.adicionar(name, price);
        System.out.println("Produto adicionado com sucesso!");
        System.out.println(product);
    }

    private static void remover(Scanner sc, CatalogoService service) {
        System.out.print("Nome do produto a remover: ");
        String name = sc.nextLine();

        boolean removido = service.removerPorNome(name);

        if (removido) {
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void buscar(Scanner sc, CatalogoService service) {
        System.out.print("Nome do produto: ");
        String name = sc.nextLine();

        Product product = service.buscarPorNome(name);

        if (product != null) {
            System.out.println("Produto encontrado:");
            System.out.println(product);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void listar(CatalogoService service) {
        List<Product> produtos = service.listarTodos();

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("=== Lista de Produtos ===");
            for (Product p : produtos) {
                System.out.println(p);
            }
        }
    }
}
