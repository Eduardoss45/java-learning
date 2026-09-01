package main.java.app;

import java.util.Scanner;

import main.java.app.model.Conta;
import main.java.app.service.ContaService;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ContaService service = new ContaService();
            int opcao;

            do {
                System.out.println("\n===== MENU BANCO =====");
                System.out.println("1. Criar conta");
                System.out.println("2. Depositar");
                System.out.println("3. Sacar");
                System.out.println("4. Consultar saldo");
                System.out.println("0. Sair");
                System.out.print("Escolha: ");
                opcao = sc.nextInt();
                sc.nextLine();

                try {
                    switch (opcao) {
                        case 1 -> criarConta(sc, service);
                        case 2 -> depositar(sc, service);
                        case 3 -> sacar(sc, service);
                        case 4 -> consultar(sc, service);
                        case 0 -> System.out.println("Saindo...");
                        default -> System.out.println("Opção inválida!");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                }

            } while (opcao != 0);
        }
    }

    private static void criarConta(Scanner sc, ContaService service) {
        System.out.print("Número da conta: ");
        int numero = sc.nextInt();
        sc.nextLine();
        System.out.print("Nome do titular: ");
        String titular = sc.nextLine();

        Conta conta = service.criarConta(numero, titular);
        System.out.println("Conta criada com sucesso!");
        System.out.println(conta);
    }

    private static void depositar(Scanner sc, ContaService service) {
        System.out.print("Número da conta: ");
        int numero = sc.nextInt();

        System.out.print("Valor do depósito: ");
        double valor = sc.nextDouble();

        service.depositar(numero, valor);
        System.out.println("Depósito realizado com sucesso!");
    }

    private static void sacar(Scanner sc, ContaService service) {
        System.out.print("Número da conta: ");
        int numero = sc.nextInt();

        System.out.print("Valor do saque: ");
        double valor = sc.nextDouble();

        service.sacar(numero, valor);
        System.out.println("Saque realizado com sucesso!");
    }

    private static void consultar(Scanner sc, ContaService service) {
        System.out.print("Número da conta: ");
        int numero = sc.nextInt();

        Conta conta = service.consultar(numero);
        System.out.println(conta);
    }
}
