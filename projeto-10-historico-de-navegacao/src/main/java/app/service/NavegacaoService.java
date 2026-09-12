package main.java.app.service;

import java.util.ArrayDeque;
import java.util.Deque;

public class NavegacaoService {
    private final Deque<String> backStack = new ArrayDeque<>();
    private final Deque<String> forwardStack = new ArrayDeque<>();
    private String currentPage = null;

    public void visitar(String url) {
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("URL não pode ser vazia.");
        }

        if (currentPage != null) {
            backStack.push(currentPage);
        }

        forwardStack.clear();

        currentPage = url;
    }

    public String voltar() {
        if (backStack.isEmpty()) {
            throw new IllegalStateException("Não há páginas para voltar.");
        }

        forwardStack.push(currentPage);

        currentPage = backStack.pop();
        return currentPage;
    }

    public String avancar() {
        if (forwardStack.isEmpty()) {
            throw new IllegalStateException("Não há páginas para avançar.");
        }

        backStack.push(currentPage);

        currentPage = forwardStack.pop();
        return currentPage;
    }

    public String getPaginaAtual() {
        if (currentPage == null) {
            throw new IllegalStateException("Nenhuma página visitada ainda.");
        }

        return currentPage;
    }

    public boolean temPaginaAtual() {
        return currentPage != null;
    }

    public boolean podeVoltar() {
        return !backStack.isEmpty();
    }

    public boolean podeAvancar() {
        return !forwardStack.isEmpty();
    }
}