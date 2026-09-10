package main.java.app;

import main.java.app.model.Client;
import main.java.app.service.FilaService;

import java.util.InputMismatchException;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            FilaService service = new FilaService();
            int opcao = -1;

            do {
                System.out.println("\n===== FILA DE ATENDIMENTO =====");
                System.out.println("1. Adicionar cliente à fila");
                System.out.println("2. Atender próximo");
                System.out.println("3. Ver próximo da fila");
                System.out.println("4. Mostrar fila completa");
                System.out.println("0. Sair");
                System.out.print("Escolha: ");

                try {
                    opcao = sc.nextInt();
                    sc.nextLine(); // limpa buffer

                    switch (opcao) {
                        case 1 -> adicionar(sc, service);
                        case 2 -> atender(service);
                        case 3 -> verProximo(service);
                        case 4 -> mostrarFila(service);
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

    private static void adicionar(Scanner sc, FilaService service) {
        System.out.print("Nome do cliente: ");
        String name = sc.nextLine();

        service.adicionar(name);
        System.out.println("Cliente adicionado à fila!");
    }

    private static void atender(FilaService service) {
        Client client = service.atenderProximo();
        System.out.println("Atendendo: " + client.getName());
    }

    private static void verProximo(FilaService service) {
        Client client = service.verProximo();
        System.out.println("Próximo da fila: " + client.getName());
    }

    private static void mostrarFila(FilaService service) {
        Queue<Client> fila = service.mostrarFila();

        if (fila.isEmpty()) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println("=== Fila atual (" + service.tamanho() + " clientes) ===");
            int posicao = 1;
            for (Client c : fila) {
                System.out.println(posicao + "º - " + c.getName());
                posicao++;
            }
        }
    }
}