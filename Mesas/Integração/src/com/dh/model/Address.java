package com.dh.model;

public class Address {
    private String logradouro;
    private String numero;
    private String complemento;
    private String cidade;
    private State estado;

    public Address(String logradouro, String numero, String cidade, State estado) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public State getEstado() {
        return estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
