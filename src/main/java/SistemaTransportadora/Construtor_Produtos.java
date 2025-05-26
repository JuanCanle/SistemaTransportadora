package SistemaTransportadora;

import java.util.ArrayList;

public class Construtor_Produtos {
    public int id;
    private String nome, descricao, família, tipo, lote,observacoes;
    Dimensoes dimensoes;
    private double peso;
    public static ArrayList<String> grauFragilidade = new ArrayList<>();

    public Construtor_Produtos(String nome, String descricao, String família, String tipo, String lote, String observacoes, Dimensoes dimensoes, double peso)
    {
        this.nome = nome;
        this.descricao = descricao;
        this.família = família;
        this.tipo = tipo;
        this.lote = lote;
        this.observacoes = observacoes;
        this.dimensoes = dimensoes;
        this.peso = peso;
    }

    //Gets e Sets
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFamília() {
        return família;
    }

    public void setFamília(String família) {
        this.família = família;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
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

    public static ArrayList<String> getGrauFragilidade() {
        return grauFragilidade;
    }

    public static void setGrauFragilidade(ArrayList<String> grauFragilidade) {
        Construtor_Produtos.grauFragilidade = grauFragilidade;
    }
    
}
