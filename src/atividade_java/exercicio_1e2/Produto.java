package atividade_java.exercicio_1e2;

class DescontoInvalidoException extends IllegalArgumentException {
    public DescontoInvalidoException(String mensagem) {
        super(mensagem);}
}

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome não deve ser nulo ou vazio.");
        }

        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if(preco < 0) {
            throw new IllegalArgumentException("O preço precisa ser maior ou igual a zero.");
        }

        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if(quantidade < 0) {
            throw new IllegalArgumentException("A quantidade precisa ser maior ou igual a zero.");
        }

        this.quantidade = quantidade;
    }

    public void aplicarDesconto(double porcentagem) {
        if(porcentagem < 0 || porcentagem > 50) {
            throw new DescontoInvalidoException("A porcentagem do desconto é inválida.");
        }

        double valorDesconto = preco * (porcentagem / 100);
        this.preco -= valorDesconto;
    }

    public void exibirInformacoes() {
        System.out.println("Nome:" + this.nome);
        System.out.println("Preço:" + this.preco);
        System.out.println("Quantidade:" + this.quantidade);
    }

    public static void main(String[] args) {
        try {
            Produto produto = new Produto("Bolsa", 1000.00, 1);
            produto.exibirInformacoes();
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }

        try {
            Produto produtoInval = new Produto("", 200, 11);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Produto produto2 = new Produto("Roupa", 300, 1);
            System.out.println("Antes de aplicar o desconto: ");
            produto2.exibirInformacoes();

            produto2.aplicarDesconto(50);
            System.out.println("Valor após o desconto: ");
            produto2.exibirInformacoes();
        } catch (DescontoInvalidoException e) {
            System.out.println(e.getMessage());
        }
    }
}
