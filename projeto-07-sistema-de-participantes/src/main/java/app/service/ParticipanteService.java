package main.java.app.service;

import java.util.HashSet;
import java.util.Set;

import main.java.app.model.Participant;

public class ParticipanteService {
    private final Set<Participant> participants = new HashSet<>();

    public boolean inscrever(String name, String email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("E-mail não pode ser vazio.");
        }

        Participant participant = new Participant(name, email);
        return participants.add(participant);
    }

    public boolean cancelar(String email) {
        Participant temp = new Participant("", email);
        return participants.remove(temp);
    }

    public boolean estaInscrito(String email) {
        Participant temp = new Participant("", email);
        return participants.contains(temp);
    }

    public Set<Participant> listarTodos() {
        return new HashSet<>(participants);
    }

    public int totalInscritos() {
        return participants.size();
    }
}