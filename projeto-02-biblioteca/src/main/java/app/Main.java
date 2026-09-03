package main.java.app;

import java.util.List;
import java.util.Scanner;

import main.java.app.model.Book;
import main.java.app.model.Loan;
import main.java.app.service.BibliotecaService;
import main.java.app.model.Member;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            BibliotecaService service = new BibliotecaService();
            int opcao;

            do {
                System.out.println("\n===== BIBLIOTECA =====");
                System.out.println("1. Cadastrar livro");
                System.out.println("2. Cadastrar membro");
                System.out.println("3. Emprestar livro");
                System.out.println("4. Devolver livro");
                System.out.println("5. Listar empréstimos ativos");
                System.out.println("0. Sair");
                System.out.print("Escolha: ");
                opcao = sc.nextInt();
                sc.nextLine();

                try {
                    switch (opcao) {
                        case 1 -> cadastrarLivro(sc, service);
                        case 2 -> cadastrarMembro(sc, service);
                        case 3 -> emprestar(sc, service);
                        case 4 -> devolver(sc, service);
                        case 5 -> listarAtivos(sc, service);
                        case 0 -> System.out.println("Saindo...");
                        default -> System.out.println("Opção inválida!");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            } while (opcao != 0);
        }
    }

    private static void cadastrarLivro(Scanner sc, BibliotecaService service) {
        System.out.print("ID do livro: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Título: ");
        String title = sc.nextLine();
        System.out.print("Autor: ");
        String author = sc.nextLine();

        Book book = service.cadastrarLivro(id, title, author);
        System.out.println("Livro cadastrado: " + book);
    }

    private static void cadastrarMembro(Scanner sc, BibliotecaService service) {
        System.out.print("ID do membro: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nome: ");
        String name = sc.nextLine();

        Member member = service.cadastrarMembro(id, name);
        System.out.println("Membro cadastrado: " + member);
    }

    private static void emprestar(Scanner sc, BibliotecaService service) {
        System.out.print("ID do livro: ");
        int bookId = sc.nextInt();
        System.out.print("ID do membro: ");
        int memberId = sc.nextInt();

        Loan loan = service.emprestarLivro(bookId, memberId);
        System.out.println("Empréstimo realizado: " + loan);
    }

    private static void devolver(Scanner sc, BibliotecaService service) {
        System.out.print("ID do livro a devolver: ");
        int bookId = sc.nextInt();

        service.devolverLivro(bookId);
        System.out.println("Livro devolvido com sucesso!");
    }

    private static void listarAtivos(Scanner sc, BibliotecaService service) {
        List<Loan> ativos = service.listarEmprestimosAtivos();
        if (ativos.isEmpty()) {
            System.out.println("Nenhum empréstimo ativo no momento.");
        } else {
            System.out.println("=== Empréstimos Ativos ===");
            ativos.forEach(System.out::println);
        }
    }
}
