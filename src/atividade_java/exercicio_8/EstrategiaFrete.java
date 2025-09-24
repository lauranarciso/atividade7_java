package atividade_java.exercicio_8;

import java.math.BigDecimal;

@FunctionalInterface
public interface EstrategiaFrete {
    BigDecimal calcular(Pedido pedido);
}