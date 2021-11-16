package com.dh.pokemon.dao;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonDAO {
    private Integer id;
    private String name;
    private Integer number;
    private String type;
    private List<String> abilities;
}
