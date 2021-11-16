package com.dh.pokemon.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Pokemon {
    private String name;
    private Integer number;
    private String type;
    private List<String> abilities;

    public Pokemon(String name, Integer number, String type, List<String> abilities) {
        this.name = name;
        this.number = number;
        this.type = type;
        this.abilities = abilities;
    }
}
