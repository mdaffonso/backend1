package com.dh.clinic.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dentist {
    private String name;
    private String cro;
    public Dentist(String name, String cro) {
        this.name = name;
        this.cro = cro;
    }
}
