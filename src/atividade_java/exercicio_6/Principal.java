package atividade_java.exercicio_6;

import java.math.BigDecimal;

public class Principal {
    public static void main(String[] args) {
        Moeda brl = Moeda.BRL;
        Produto teclado = new Produto(1L, "Blush", new Dinheiro(new BigDecimal("350.55"), brl));
        Produto mouse = new Produto(2L, "Corretivo", new Dinheiro(new BigDecimal("120.40"), brl));
        Produto monitor = new Produto(3L, "Monitor", new Dinheiro(new BigDecimal("1850.00"), brl));

        Carrinho carrinho1 = new Carrinho();
        System.out.println("1. Carrinho inicial: " + carrinho1);

        Carrinho carrinho2 = carrinho1.adicionarItem(teclado, 1);
        System.out.println("2. Após adicionar blush: " + carrinho2);

        Carrinho carrinho3 = carrinho2.adicionarItem(mouse, 2);
        System.out.println("3. Após adicionar 2 corretivos: " + carrinho3);
        System.out.println("Itens no carrinho 3: " + carrinho3.getItens());

        Carrinho carrinho4 = carrinho3.removerItem(teclado);
        System.out.println("4. Após remover blush: " + carrinho4);

        Carrinho carrinho5 = carrinho4.aplicarCupom(new BigDecimal("10"));
        System.out.println("5. Com cupom de 10%: " + carrinho5);

        System.out.println("Verificação da Imutabilidade");
        System.out.println("O carrinho 1 ainda está vazio: " + carrinho1);
        System.out.println("O carrinho 3 ainda tem o blush: " + carrinho3);

        System.out.println("Demonstração de validações");
        try {
            carrinho1.adicionarItem(monitor, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado ao adicionar item com quantidade 0: " + e.getMessage());
        }

        try {
            carrinho5.aplicarCupom(new BigDecimal("45"));
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado ao aplicar cupom > 30%: " + e.getMessage());
        }
    }
}