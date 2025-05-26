package SistemaTransportadora;

import java.util.ArrayList;

public class Construtor_Embalagens {
    private Construtor_Produtos produtos_associados;
    private Dimensoes dimensoes;
    private double peso;
    private boolean empilhavel;
    private String observacoes;
    public static ArrayList<String> tiposEmbalagem = new ArrayList<>();

    public Construtor_Embalagens(Construtor_Produtos produtos_associados, Dimensoes dimensoes, double peso, boolean empilhavel, String observacoes)
    {
        this.produtos_associados = produtos_associados;
        this.dimensoes = dimensoes;
        this.peso = peso;
        this.empilhavel = empilhavel;
        this.observacoes = observacoes;
    }

    //Gets e Sets
    public Construtor_Produtos getProdutos_associados() {
        return produtos_associados;
    }

    public void setProdutos_associados(Construtor_Produtos produtos_associados) {
        this.produtos_associados = produtos_associados;
    }

    public Dimensoes getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(Dimensoes dimensoes) {
        this.dimensoes = dimensoes;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isEmpilhavel() {
        return empilhavel;
    }

    public void setEmpilhavel(boolean empilhavel) {
        this.empilhavel = empilhavel;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public static ArrayList<String> getTiposEmbalagem() {
        return tiposEmbalagem;
    }

    public static void setTiposEmbalagem(ArrayList<String> tiposEmbalagem) {
        Construtor_Embalagens.tiposEmbalagem = tiposEmbalagem;
    }
  
}
