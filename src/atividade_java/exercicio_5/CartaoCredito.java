package atividade_java.exercicio_5;

public class CartaoCredito extends FormaPagamento {
    private String numeroCartao;
    private String nomeTitular;

    public CartaoCredito(String numeroCartao, String nomeTitular) {
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
    }

    @Override
    public void validarPagamento() throws Exception {
        if (numeroCartao == null || !numeroCartao.matches("\\d{16}")) {
            throw new Exception("Número do cartão de crédito inválido.");
        }
        if (nomeTitular == null || nomeTitular.trim().isEmpty()) {
            throw new Exception("O nome do titular é obrigatório.");
        }
    }
}
