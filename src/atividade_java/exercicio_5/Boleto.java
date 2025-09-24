package atividade_java.exercicio_5;

public class Boleto extends FormaPagamento {
    private String codigoBarras;

    public Boleto(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void validarPagamento() throws Exception {
        if (codigoBarras == null || !codigoBarras.matches("\\d{48}")) {
            throw new Exception("O código de barras do boleto é inválido.");
        }
    }
}