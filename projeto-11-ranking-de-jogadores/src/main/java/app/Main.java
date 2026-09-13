package main.java.app;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import main.java.app.model.Player;
import main.java.app.service.RankingService;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            RankingService service = new RankingService();
            int opcao = -1;

            do {
                System.out.println("\n===== RANKING DE JOGADORES =====");
                System.out.println("1. Cadastrar jogador");
                System.out.println("2. Ranking por pontuação");
                System.out.println("3. Ranking por nome");
                System.out.println("4. Ranking por idade");
                System.out.println("0. Sair");
                System.out.print("Escolha: ");

                try {
                    opcao = sc.nextInt();
                    sc.nextLine();

                    switch (opcao) {
                        case 1 -> cadastrar(sc, service);
                        case 2 -> mostrarRanking(service.rankingPorPontuacao(), "Pontuação");
                        case 3 -> mostrarRanking(service.rankingPorNome(), "Nome");
                        case 4 -> mostrarRanking(service.rankingPorIdade(), "Idade");
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

    private static void cadastrar(Scanner sc, RankingService service) {
        System.out.print("Nome: ");
        String name = sc.nextLine();

        System.out.print("Pontuação: ");
        int score = sc.nextInt();

        System.out.print("Idade: ");
        int age = sc.nextInt();
        sc.nextLine();

        service.cadastrar(name, score, age);
        System.out.println("Jogador cadastrado com sucesso!");
    }

    private static void mostrarRanking(List<Player> ranking, String criterio) {
        if (ranking.isEmpty()) {
            System.out.println("Nenhum jogador cadastrado.");
            return;
        }

        System.out.println("=== Ranking por " + criterio + " ===");
        int posicao = 1;
        for (Player p : ranking) {
            System.out.println(posicao + "º - " + p);
            posicao++;
        }
    }
}
