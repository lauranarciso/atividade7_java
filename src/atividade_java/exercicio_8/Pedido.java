package atividade_java.exercicio_8;

import java.math.BigDecimal;

public class Pedido {
    private final long id;
    private final BigDecimal valorTotal;
    private final String cepDestino;

    private EstrategiaFrete estrategiaFrete;

    public Pedido(long id, BigDecimal valorTotal, String cepDestino) throws CepInvalidoException {
        this.id = id;
        this.valorTotal = valorTotal;

        if (cepDestino == null || !cepDestino.matches("\\d{8}")) {
            throw new CepInvalidoException("O formato do CEP '" + cepDestino + "' é inválido. Deve conter 8 dígitos.");
        }
        this.cepDestino = cepDestino;
    }

    public void setEstrategiaFrete(EstrategiaFrete estrategiaFrete) {
        this.estrategiaFrete = estrategiaFrete;
    }

    // O método que usa a estratégia
    public BigDecimal calcularFrete() {
        if (estrategiaFrete == null) {
            throw new IllegalStateException("Nenhuma estratégia de frete foi definida pro pedido.");
        }
        return estrategiaFrete.calcular(this);
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public String getCepDestino() {
        return cepDestino;
    }
}