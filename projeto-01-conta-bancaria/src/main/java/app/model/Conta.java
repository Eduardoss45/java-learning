package main.java.app.model;

public class Conta {
    private int numero;
    private String titular;
    private double saldo;

    public Conta(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do depósito deve ser positivo.");
        }

        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser positivo.");
        }

        if (valor > this.saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }

        this.saldo -= valor;
    }

    @Override
    public String toString() {
        return String.format("Conta %d | Titular: %s | Saldo: %.2f", numero, titular, saldo);
    }
}
