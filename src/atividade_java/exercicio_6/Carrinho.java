package atividade_java.exercicio_6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Carrinho {
    private final List<ItemCarrinho> itens;
    private final BigDecimal cupomDescontoPercentual;

    public Carrinho() {
        this.itens = Collections.emptyList();
        this.cupomDescontoPercentual = BigDecimal.ZERO;
    }

    private Carrinho(List<ItemCarrinho> itens, BigDecimal cupom) {
        this.itens = new ArrayList<>(itens);
        this.cupomDescontoPercentual = cupom;
    }

    public List<ItemCarrinho> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public Carrinho adicionarItem(Produto produto, int quantidade) {
        List<ItemCarrinho> novosItens = new ArrayList<>(this.itens);
        novosItens.stream()
                .filter(item -> item.getProduto().equals(produto))
                .findFirst()
                .ifPresent(itemExistente -> {
                    throw new UnsupportedOperationException("Esse produto já existe no carrinho. Use um método 'atualizarQuantidade' se necessário.");
                });

        novosItens.add(new ItemCarrinho(produto, quantidade));
        return new Carrinho(novosItens, this.cupomDescontoPercentual);
    }

    public Carrinho removerItem(Produto produto) {
        List<ItemCarrinho> novosItens = this.itens.stream()
                .filter(item -> !item.getProduto().equals(produto))
                .collect(Collectors.toList());
        return new Carrinho(novosItens, this.cupomDescontoPercentual);
    }

    public Carrinho aplicarCupom(BigDecimal porcentagem) {
        if (porcentagem.compareTo(BigDecimal.ZERO) < 0 || porcentagem.compareTo(new BigDecimal("30")) > 0) {
            throw new IllegalArgumentException("O cupom de desconto deve ser entre 0 e 30%.");
        }
        return new Carrinho(this.itens, porcentagem);
    }

    public BigDecimal getValorTotal() {
        BigDecimal subtotal = itens.stream()
                .map(ItemCarrinho::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (cupomDescontoPercentual.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal fatorDesconto = BigDecimal.ONE.subtract(cupomDescontoPercentual.divide(new BigDecimal("100")));
            BigDecimal totalComDesconto = subtotal.multiply(fatorDesconto);
            return totalComDesconto.setScale(2, RoundingMode.HALF_EVEN);
        }

        return subtotal.setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public String toString() {
        return "Carrinho{itens=" + itens.size() + ", cupom=" + cupomDescontoPercentual + "%, total=" + getValorTotal() + "}";
    }
}