package main.java.app;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import main.java.app.model.Contact;
import main.java.app.service.AgendaService;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            AgendaService service = new AgendaService();
            int opcao = -1;

            do {
                System.out.println("\n===== AGENDA TELEFÔNICA =====");
                System.out.println("1. Adicionar contato");
                System.out.println("2. Buscar contato por nome");
                System.out.println("3. Remover contato");
                System.out.println("4. Listar contatos");
                System.out.println("0. Sair");
                System.out.print("Escolha: ");

                try {
                    opcao = sc.nextInt();
                    sc.nextLine();

                    switch (opcao) {
                        case 1 -> adicionar(sc, service);
                        case 2 -> buscar(sc, service);
                        case 3 -> remover(sc, service);
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

    private static void adicionar(Scanner sc, AgendaService service) {
        System.out.print("Nome: ");
        String name = sc.nextLine();

        System.out.print("Telefone: ");
        String phone = sc.nextLine();

        service.adicionar(name, phone);
        System.out.println("Contato adicionado com sucesso!");
    }

    private static void buscar(Scanner sc, AgendaService service) {
        System.out.print("Nome do contato: ");
        String name = sc.nextLine();

        Contact contact = service.buscarPorNome(name);

        if (contact != null) {
            System.out.println("Contato encontrado: " + contact);
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    private static void remover(Scanner sc, AgendaService service) {
        System.out.print("Nome do contato a remover: ");
        String name = sc.nextLine();

        boolean removido = service.remover(name);

        if (removido) {
            System.out.println("Contato removido com sucesso!");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    private static void listar(AgendaService service) {
        Map<String, Contact> contatos = service.listarTodos();

        if (contatos.isEmpty()) {
            System.out.println("Agenda vazia.");
        } else {
            System.out.println("=== Contatos (" + service.totalContatos() + ") ===");
            for (Contact c : contatos.values()) {
                System.out.println(c);
            }
        }
    }
}