package main.java.app.model;

public class Loan {
    private Book book;
    private Member member;
    private boolean active;

    public Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.active = true;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return String.format("Empréstimo | Livro: %s | Membro: %s | Status: %s", book.getTitle(), member.getName(),
                active ? "Ativo" : "Devolvido");
    }
}
