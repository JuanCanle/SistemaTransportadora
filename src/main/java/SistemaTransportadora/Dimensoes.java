package SistemaTransportadora;

public class Dimensoes 
{
    private double altura,largura,comprimento;

    public Dimensoes(double altura, double largura, double comprimento)
    {
        this.altura=altura;
        this.comprimento=comprimento;
        this.largura=largura;
    }

    // Gets e Sets
    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }
}
