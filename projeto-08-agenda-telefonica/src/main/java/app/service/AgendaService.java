package main.java.app.service;

import java.util.HashMap;
import java.util.Map;

import main.java.app.model.Contact;

public class AgendaService {
    private final Map<String, Contact> contacts = new HashMap<>();

    public void adicionar(String name, String phone) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("Telefone não pode ser vazio.");
        }

        contacts.put(name.toLowerCase(), new Contact(name, phone));
    }

    public Contact buscarPorNome(String name) {
        return contacts.get(name.toLowerCase());
    }

    public boolean remover(String name) {
        return contacts.remove(name.toLowerCase()) != null;
    }

    public Map<String, Contact> listarTodos() {
        return new HashMap<>(contacts);
    }

    public boolean estaVazia() {
        return contacts.isEmpty();
    }

    public int totalContatos() {
        return contacts.size();
    }
}
