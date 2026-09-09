package main.java.app;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import main.java.app.model.Participant;
import main.java.app.service.ParticipanteService;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ParticipanteService service = new ParticipanteService();
            int opcao = -1;

            do {
                System.out.println("\n===== SISTEMA DE PARTICIPANTES =====");
                System.out.println("1. Inscrever participante");
                System.out.println("2. Cancelar inscrição");
                System.out.println("3. Verificar se está inscrito");
                System.out.println("4. Listar participantes");
                System.out.println("0. Sair");
                System.out.print("Escolha: ");

                try {
                    opcao = sc.nextInt();
                    sc.nextLine();

                    switch (opcao) {
                        case 1 -> inscrever(sc, service);
                        case 2 -> cancelar(sc, service);
                        case 3 -> verificar(sc, service);
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

    private static void inscrever(Scanner sc, ParticipanteService service) {
        System.out.print("Nome: ");
        String name = sc.nextLine();

        System.out.print("E-mail: ");
        String email = sc.nextLine();

        boolean sucesso = service.inscrever(name, email);

        if (sucesso) {
            System.out.println("Participante inscrito com sucesso!");
        } else {
            System.out.println("Este e-mail já está inscrito.");
        }
    }

    private static void cancelar(Scanner sc, ParticipanteService service) {
        System.out.print("E-mail do participante: ");
        String email = sc.nextLine();

        boolean removido = service.cancelar(email);

        if (removido) {
            System.out.println("Inscrição cancelada com sucesso!");
        } else {
            System.out.println("Participante não encontrado.");
        }
    }

    private static void verificar(Scanner sc, ParticipanteService service) {
        System.out.print("E-mail: ");
        String email = sc.nextLine();

        if (service.estaInscrito(email)) {
            System.out.println("Participante está inscrito.");
        } else {
            System.out.println("Participante NÃO está inscrito.");
        }
    }

    private static void listar(ParticipanteService service) {
        Set<Participant> lista = service.listarTodos();

        if (lista.isEmpty()) {
            System.out.println("Nenhum participante inscrito.");
        } else {
            System.out.println("=== Participantes Inscritos (" + service.totalInscritos() + ") ===");
            for (Participant p : lista) {
                System.out.println(p);
            }
        }
    }
}
