package main.java.app.service;

import java.util.LinkedList;
import java.util.Queue;

import main.java.app.model.Client;

public class FilaService {
    private final Queue<Client> queue = new LinkedList<>();

    public void adicionar(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nome do cliente não pode ser vazio.");
        }
        queue.offer(new Client(name));
    }

    public Client atenderProximo() {
        Client client = queue.poll();
        if (client == null) {
            throw new IllegalStateException("A fila está vazia.");
        }
        return client;
    }

    public Client verProximo() {
        Client client = queue.peek();
        if (client == null) {
            throw new IllegalStateException("A fila está vazia.");
        }
        return client;
    }

    public Queue<Client> mostrarFila() {
        return new LinkedList<>(queue);
    }

    public boolean estaVazia() {
        return queue.isEmpty();
    }

    public int tamanho() {
        return queue.size();
    }
}