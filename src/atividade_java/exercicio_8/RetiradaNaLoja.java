package atividade_java.exercicio_8;

import java.math.BigDecimal;

public class RetiradaNaLoja implements EstrategiaFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        return BigDecimal.ZERO;
    }
}
