package main.java.app;

import java.util.List;
import java.util.Scanner;

import main.java.app.model.Employee;
import main.java.app.service.FuncionarioService;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            FuncionarioService service = new FuncionarioService();
            int opcao;

            do {
                System.out.println("\n===== SISTEMA DE FUNCIONÁRIOS =====");
                System.out.println("1. Cadastrar funcionário");
                System.out.println("2. Listar funcionários");
                System.out.println("3. Calcular folha de pagamento total");
                System.out.println("0. Sair");
                System.out.print("Escolha: ");
                opcao = sc.nextInt();
                sc.nextLine();

                try {
                    switch (opcao) {
                        case 1 -> cadastrar(sc, service);
                        case 2 -> listar(service);
                        case 3 -> calcularFolha(service);
                        case 0 -> System.out.println("Saindo...");
                        default -> System.out.println("Opção inválida!");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            } while (opcao != 0);
        }
    }

    private static void cadastrar(Scanner sc, FuncionarioService service) {
        System.out.println("Tipo de funcionário:");
        System.out.println("1. Developer");
        System.out.println("2. Manager");
        System.out.println("3. Designer");
        System.out.print("Escolha: ");
        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nome: ");
        String name = sc.nextLine();
        System.out.print("Salário base: ");
        double baseSalary = sc.nextDouble();

        switch (tipo) {
            case 1 -> {
                System.out.print("Projetos concluídos: ");
                int projects = sc.nextInt();
                service.cadastrarDeveloper(id, name, baseSalary, projects);
            }
            case 2 -> {
                System.out.print("Tamanho da equipe: ");
                int teamSize = sc.nextInt();
                service.cadastrarManager(id, name, baseSalary, teamSize);
            }
            case 3 -> {
                System.out.print("Designs concluídos: ");
                int designs = sc.nextInt();
                service.cadastrarDesigner(id, name, baseSalary, designs);
            }
            default -> throw new IllegalArgumentException("Tipo inválido.");
        }

        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private static void listar(FuncionarioService service) {
        List<Employee> lista = service.listarTodos();
        if (lista.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            System.out.println("=== Funcionários ===");
            lista.forEach(System.out::println);
        }
    }

    private static void calcularFolha(FuncionarioService service) {
        double total = service.calcularFolhaTotal();
        System.out.printf("Folha de pagamento total: R$ %.2f%n", total);
    }
}
