package SistemaTransportadora;

import java.util.ArrayList;

public class Construtor_Veiculos {
    private int id;
    private String nome, placa, modelo, observacoes;
    private double capacidade_peso;
    private Dimensoes dimensoes;
    public static ArrayList<String> tiposCaminhao = new ArrayList<>();

    public Construtor_Veiculos(String nome, String placa, String modelo, String observacoes,Dimensoes dimensoes, double capacidade_peso)
    {
        this.nome = nome;
        this.placa = placa;
        this.modelo = modelo;
        this.observacoes = observacoes;
        this.dimensoes=dimensoes;
        this.capacidade_peso = capacidade_peso;
    }

    // Gets e Sets
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public double getCapacidade_peso() {
        return capacidade_peso;
    }

    public void setCapacidade_peso(double capacidade_peso) {
        this.capacidade_peso = capacidade_peso;
    }

    public Dimensoes getDimesoes() {
        return dimensoes;
    }

    public void setDimesoes(Dimensoes dimesoes) {
        this.dimensoes = dimesoes;
    }

    public static ArrayList<String> getTiposCaminhao() {
        return tiposCaminhao;
    }

    public static void setTiposCaminhao(ArrayList<String> tiposCaminhao) {
        Construtor_Veiculos.tiposCaminhao = tiposCaminhao;
    }
}
