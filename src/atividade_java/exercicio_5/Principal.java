package atividade_java.exercicio_5;

import java.math.BigDecimal;

public class Principal {
    public static void main(String[] args) {
        BigDecimal valorCompra = new BigDecimal("250.75");

        FormaPagamento cartao = new CartaoCredito("1234567812345678", "Laura");
        FormaPagamento boleto = new Boleto("123456789012345678901234567890123456789012345678");
        FormaPagamento cartaoInvalido = new CartaoCredito("123", "");

        System.out.println("Processando pagamentos");
        try {
            cartao.processarPagamento(valorCompra);
        } catch (Exception e) {
            System.out.println("Falha no pagamento: " + e.getMessage());
        }

        try {
            boleto.processarPagamento(valorCompra);
        } catch (Exception e) {
            System.out.println("Falha no pagamento: " + e.getMessage());
        }

        System.out.println("Tentando pagamento inválido");
        try {
            cartaoInvalido.processarPagamento(valorCompra);
        } catch (Exception e) {
            System.out.println("Falha no pagamento: " + e.getMessage());
        }
    }
}