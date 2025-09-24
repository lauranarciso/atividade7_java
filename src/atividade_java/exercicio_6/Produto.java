package atividade_java.exercicio_6;

import java.util.Objects;

public final class Produto {
    private final long id;
    private final String nome;
    private final Dinheiro preco;

    public Produto(long id, String nome, Dinheiro preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public long getId() { return id; }
    public String getNome() { return nome; }
    public Dinheiro getPreco() { return preco; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id == produto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Produto{id=" + id + ", nome='" + nome + "', preco=" + preco + "}";
    }
}