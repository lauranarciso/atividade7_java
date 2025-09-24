package atividade_java.exercicio_8;

import java.math.BigDecimal;

public class Pac implements EstrategiaFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        BigDecimal taxaPercentual = pedido.getValorTotal().multiply(new BigDecimal("0.07"));
        BigDecimal taxaFixa = new BigDecimal("12.00");
        return taxaPercentual.add(taxaFixa);
    }
}
