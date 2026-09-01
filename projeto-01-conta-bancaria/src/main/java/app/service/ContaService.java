package main.java.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import main.java.app.model.Conta;

public class ContaService {
    private final List<Conta> contas = new ArrayList<>();

    public Conta criarConta(int numero, String titular) {
        if (buscarPorNumero(numero).isPresent()) {
            throw new IllegalArgumentException("Já existe uma conta com este número.");
        }

        Conta nova = new Conta(numero, titular);
        contas.add(nova);
        return nova;
    }

    public Optional<Conta> buscarPorNumero(int numero) {
        return contas.stream().filter(c -> c.getNumero() == numero).findFirst();
    }

    public void depositar(int numero, double valor) {
        Conta conta = buscarPorNumero(numero).orElseThrow(() -> new IllegalArgumentException("Conta não encontrada."));
        conta.depositar(valor);
    }

    public void sacar(int numero, double valor) {
        Conta conta = buscarPorNumero(numero).orElseThrow(() -> new IllegalArgumentException("Conta não encontrada."));
        conta.sacar(valor);
    }

    public Conta consultar(int numero) {
        return buscarPorNumero(numero)
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada."));
    }

    public List<Conta> listarTodas() {
        return new ArrayList<>(contas);
    }
}
