package main.java.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import main.java.app.service.NavegacaoService;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            NavegacaoService service = new NavegacaoService();
            int opcao = -1;

            do {
                System.out.println("\n===== HISTÓRICO DE NAVEGAÇÃO =====");
                System.out.println("1. Visitar página (nova URL)");
                System.out.println("2. Voltar");
                System.out.println("3. Avançar");
                System.out.println("4. Mostrar página atual");
                System.out.println("0. Sair");
                System.out.print("Escolha: ");

                try {
                    opcao = sc.nextInt();
                    sc.nextLine();

                    switch (opcao) {
                        case 1 -> visitar(sc, service);
                        case 2 -> voltar(service);
                        case 3 -> avancar(service);
                        case 4 -> mostrarAtual(service);
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

    private static void visitar(Scanner sc, NavegacaoService service) {
        System.out.print("Digite a URL: ");
        String url = sc.nextLine();

        service.visitar(url);
        System.out.println("Página atual: " + service.getPaginaAtual());
    }

    private static void voltar(NavegacaoService service) {
        String pagina = service.voltar();
        System.out.println("Voltou para: " + pagina);
    }

    private static void avancar(NavegacaoService service) {
        String pagina = service.avancar();
        System.out.println("Avançou para: " + pagina);
    }

    private static void mostrarAtual(NavegacaoService service) {
        System.out.println("Página atual: " + service.getPaginaAtual());
    }
}
