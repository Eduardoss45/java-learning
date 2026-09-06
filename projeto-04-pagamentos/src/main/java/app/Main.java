package main.java.app;

import java.util.List;
import java.util.Scanner;

import main.java.app.model.CreditCard;
import main.java.app.model.Payment;
import main.java.app.model.PaymentMethod;
import main.java.app.model.Pix;
import main.java.app.model.Transfer;
import main.java.app.service.PagamentoService;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            PagamentoService service = new PagamentoService();
            int opcao;

            do {
                System.out.println("\n===== SISTEMA DE PAGAMENTOS =====");
                System.out.println("1. Cadastrar forma de pagamento");
                System.out.println("2. Processar pagamento");
                System.out.println("3. Listar pagamentos processados");
                System.out.println("0. Sair");
                System.out.print("Escolha: ");
                opcao = sc.nextInt();
                sc.nextLine();

                try {
                    switch (opcao) {
                        case 1 -> cadastrarMetodo(sc, service);
                        case 2 -> processar(sc, service);
                        case 3 -> listarProcessados(service);
                        case 0 -> System.out.println("Saindo...");
                        default -> System.out.println("Opção inválida!");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            } while (opcao != 0);
        }
    }

    private static void cadastrarMetodo(Scanner sc, PagamentoService service) {
        System.out.println("Escolha a forma de pagamento:");
        System.out.println("1. PIX");
        System.out.println("2. Cartão de Crédito");
        System.out.println("3. Transferência");
        System.out.print("Opção: ");
        int tipo = sc.nextInt();

        PaymentMethod method = switch (tipo) {
            case 1 -> new Pix();
            case 2 -> new CreditCard();
            case 3 -> new Transfer();
            default -> throw new IllegalArgumentException("Tipo inválido.");
        };

        service.cadastrarMetodo(method);
        System.out.println("Forma de pagamento cadastrada: " + method.getName());
    }

    private static void processar(Scanner sc, PagamentoService service) {
        List<PaymentMethod> metodos = service.listarMetodos();

        if (metodos.isEmpty()) {
            System.out.println("Nem uma forma de pagamento cadastrada.");
            return;
        }

        System.out.println("=== Formas de pagamento disponíveis ===");
        for (int i = 0; i < metodos.size(); i++) {
            System.out.println(i + " - " + metodos.get(i).getName());
        }

        System.out.print("Escolha o índice do método: ");
        int index = sc.nextInt();
        System.out.print("Valor do pagamento: ");
        double valor = sc.nextDouble();

        service.processarPagameto(index, valor);
        System.out.println("Pagamento processado com sucesso!");
    }

    private static void listarProcessados(PagamentoService service) {
        List<Payment> pagamentos = service.listarPagamentosProcessados();

        if (pagamentos.isEmpty()) {
            System.out.println("Nenhum pagamento processado ainda.");
        } else {
            System.out.println("=== Pagamentos Processados ===");
            pagamentos.forEach(System.out::println);
        }
    }
}