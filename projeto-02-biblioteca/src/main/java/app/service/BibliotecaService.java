package main.java.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import main.java.app.model.Book;
import main.java.app.model.Member;
import main.java.app.model.Loan;

public class BibliotecaService {
    private final List<Book> books = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();
    private final List<Loan> loans = new ArrayList<>();

    public Book cadastrarLivro(int id, String title, String author) {
        if (buscarLivroPorId(id).isPresent()) {
            throw new IllegalArgumentException("Já existe um livro com este ID.");
        }

        Book book = new Book(id, title, author);
        books.add(book);
        return book;
    }

    public Optional<Book> buscarLivroPorId(int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst();
    }

    public Member cadastrarMembro(int id, String name) {
        if (buscarMembroPorId(id).isPresent()) {
            throw new IllegalArgumentException("Já existe um membro com este ID.");
        }

        Member member = new Member(id, name);
        members.add(member);
        return member;
    }

    public Optional<Member> buscarMembroPorId(int id) {
        return members.stream().filter(m -> m.getId() == id).findFirst();
    }

    public Loan emprestarLivro(int bookId, int memberId) {
        Book book = buscarLivroPorId(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado."));

        Member member = buscarMembroPorId(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Membro não encontrado."));

        if (!book.isAvailable()) {
            throw new IllegalArgumentException("Este livro já está emprestado.");
        }

        Loan loan = new Loan(book, member);
        loans.add(loan);

        book.setAvailable(false);

        return loan;
    }

    public void devolverLivro(int bookId) {
        Loan loan = loans.stream().filter(l -> l.isActive() && l.getBook().getId() == bookId).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Não existe empréstimo ativo para este livro."));

        loan.setActive(false);
        loan.getBook().setAvailable(true);
    }

    public List<Loan> listarEmprestimosAtivos() {
        return loans.stream().filter(Loan::isActive).toList();
    }
}
