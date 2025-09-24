package atividade_java.exercicio_5;

import java.math.BigDecimal;

public abstract class FormaPagamento {
    public abstract void validarPagamento() throws Exception;

    public void processarPagamento(BigDecimal valor) throws Exception {
        validarPagamento();
        System.out.printf("Processando pagamento de R$ %.2f via %s...%n", valor, this.getClass().getSimpleName());
        System.out.println("O pagamento foi aprovado");
    }
}
