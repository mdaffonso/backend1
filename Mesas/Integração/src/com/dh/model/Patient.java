package com.dh.model;

import java.time.LocalDate;

public class Patient {
    private String nome;
    private String sobrenome;
    private String rg;
    private LocalDate dataCadastro;
    private Address endereco;

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getRg() {
        return rg;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public Address getEndereco() {
        return endereco;
    }
}
