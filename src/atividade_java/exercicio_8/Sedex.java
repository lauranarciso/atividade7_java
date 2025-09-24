package atividade_java.exercicio_8;

import java.math.BigDecimal;

public class Sedex implements EstrategiaFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        BigDecimal taxaPercentual = pedido.getValorTotal().multiply(new BigDecimal("0.12"));
        BigDecimal taxaFixa = new BigDecimal("18.00");
        return taxaPercentual.add(taxaFixa);
    }
}