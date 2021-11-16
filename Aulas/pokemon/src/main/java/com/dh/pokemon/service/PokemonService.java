package com.dh.pokemon.service;

import com.dh.pokemon.dao.PokemonDAO;
import com.dh.pokemon.domain.Pokemon;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PokemonService {
    private static Map<Integer, Pokemon> pokemonMap = new HashMap<>();

    public Map<Integer, Pokemon> fetchAll() {
        return pokemonMap;
    }

    public Pokemon insert(PokemonDAO p) {
        Integer id = pokemonMap.size() + 1;
        Pokemon pokemon = new Pokemon(p.getName(), p.getNumber(), p.getType(), p.getAbilities());
        pokemonMap.put(id, pokemon);
        return pokemonMap.get(id);
    }

    public Pokemon edit(PokemonDAO p) {
        Pokemon pokemon = pokemonMap.get(p.getId());
        if (pokemon == null) {
            return pokemon;
        }
        pokemon.setAbilities(p.getAbilities());
        pokemon.setType(p.getType());

        pokemonMap.put(p.getId(), pokemon);
        return pokemon;
    }

    public Pokemon fetchOne(Integer id) {
        return pokemonMap.get(id);
    }

    public void delete(Integer id) {
        pokemonMap.remove(id);
    }
}
