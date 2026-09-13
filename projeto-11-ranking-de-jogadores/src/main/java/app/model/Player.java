package main.java.app.model;

public class Player implements Comparable<Player> {
    private final String name;
    private final int score;
    private final int age;

    public Player(String name, int score, int age) {
        this.name = name;
        this.score = score;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Player other) {
        return Integer.compare(other.score, this.score);
    }

    @Override
    public String toString() {
        return String.format("%s | Pontos: %d | Idade: %d", name, score, age);
    }
}