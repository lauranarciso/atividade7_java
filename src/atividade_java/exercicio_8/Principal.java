package atividade_java.exercicio_8;

import java.math.BigDecimal;

public class Principal {
    public static void main(String[] args) {
        try {
            Pedido pedido = new Pedido(1L, new BigDecimal("450.00"), "94010030");
            System.out.println("O pedido foi criado com valor de R$ " + pedido.getValorTotal());

            pedido.setEstrategiaFrete(new Sedex());
            System.out.printf("O custo do frete (SEDEX) é: R$ %.2f%n", pedido.calcularFrete());

            pedido.setEstrategiaFrete(new Pac());
            System.out.printf("Custo do frete (PAC): R$ %.2f%n", pedido.calcularFrete());

            pedido.setEstrategiaFrete(new RetiradaNaLoja());
            System.out.printf("Custo do frete (Retirada na Loja): R$ %.2f%n", pedido.calcularFrete());

            System.out.println("Demonstração com Lambda");

            EstrategiaFrete fretePromocional = p -> {
                if (p.getValorTotal().compareTo(new BigDecimal("400.00")) > 0) {
                    System.out.println("Aplicando promoção de frete grátis!");
                    return BigDecimal.ZERO;
                } else {
                    return new BigDecimal("25.00");
                }
            };

            pedido.setEstrategiaFrete(fretePromocional);
            System.out.printf("Custo do frete (Promocional): R$ %.2f%n", pedido.calcularFrete());

            System.out.println("Demonstração de Validação");
            System.out.println("Tentando criar pedido com CEP '123-456'...");
            Pedido pedidoInvalido = new Pedido(2L, new BigDecimal("100.00"), "123-456");

        } catch (CepInvalidoException e) {
            System.out.println("ERRO: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }
}
