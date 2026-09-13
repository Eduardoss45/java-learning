package main.java.app.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import main.java.app.model.Player;

public class RankingService {
    private final List<Player> players = new ArrayList<>();

    public void cadastrar(String name, int score, int age) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        if (score < 0) {
            throw new IllegalArgumentException("Pontuação não pode ser negativa.");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("Idade deve ser positiva.");
        }

        players.add(new Player(name, score, age));
    }

    public List<Player> rankingPorPontuacao() {
        List<Player> ranking = new ArrayList<>(players);
        ranking.sort(null);
        return ranking;
    }

    public List<Player> rankingPorNome() {
        List<Player> ranking = new ArrayList<>(players);
        ranking.sort(Comparator.comparing(Player::getName));
        return ranking;
    }

    public List<Player> rankingPorIdade() {
        List<Player> ranking = new ArrayList<>(players);
        ranking.sort(Comparator.comparingInt(Player::getAge));
        return ranking;
    }

    public boolean estaVazio() {
        return players.isEmpty();
    }
}
