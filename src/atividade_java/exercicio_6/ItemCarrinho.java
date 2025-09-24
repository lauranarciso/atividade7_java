package atividade_java.exercicio_6;

import java.math.BigDecimal;

public final class ItemCarrinho {
    private final Produto produto;
    private final int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getSubtotal() {
        return produto.getPreco().getValor().multiply(new BigDecimal(quantidade));
    }

    @Override
    public String toString() {
        return "ItemCarrinho{produto=" + produto.getNome() + ", quantidade=" + quantidade + ", subtotal=" + getSubtotal() + "}";
    }
}
