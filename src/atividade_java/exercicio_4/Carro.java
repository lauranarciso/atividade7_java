package atividade_java.exercicio_4;

public class Carro implements IMeioTransporte{
    private int velocidade;
    private final int limiteVelocidade;

    public Carro(){
        this.velocidade = 0;
        this.limiteVelocidade = 180;
    }

    @Override
    public void acelerar() {
        if(this.velocidade < this.limiteVelocidade){
            this.velocidade += 10;
            System.out.println("O carro está em aceleração, a velocidade atual é: " + this.velocidade);
        } else {
            throw new IllegalStateException("O carro atingiu o limite de velocidade!");
        }
    }

    @Override
    public void frear() {
        if(this.velocidade > 0) {
            this.velocidade -= 10;
            System.out.println("O carro está freando, a velocidade atual é: " + this.velocidade);
        }
    }
}