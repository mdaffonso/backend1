package com.dh.pokemon.controller;

import com.dh.pokemon.dao.PokemonDAO;
import com.dh.pokemon.domain.Pokemon;
import com.dh.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("pokemon")
public class PokemonController {

    @Autowired
    private PokemonService service;

    @GetMapping
    public Map<Integer, Pokemon> getAll() {
        return service.fetchAll();
    }

    @PostMapping
    public Pokemon create(@RequestBody PokemonDAO p) {
        return service.insert(p);
    }

    @PutMapping
    public Pokemon edit(@RequestBody PokemonDAO p) {
        return service.edit(p);
    }

    @GetMapping("{id}")
    public Pokemon get(@PathVariable Integer id) {
        return service.fetchOne(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
