package com.dh.hql.controller;

import com.dh.hql.dao.JogadorDAO;
import com.dh.hql.model.Jogador;
import com.dh.hql.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jogador")
public class JogadorController {

    @Autowired
    private JogadorService service;

    @PostMapping
    public ResponseEntity<Jogador> create(@RequestBody JogadorDAO dao) {
        return ResponseEntity.ok(service.create(dao));
    }

    @GetMapping
    public ResponseEntity<List<Jogador>> all() {
        return ResponseEntity.ok(service.all());
    }

    @GetMapping("treinador/{id}")
    public ResponseEntity<List<String>> filterByTreinador(@PathVariable Integer id) {
        return ResponseEntity.ok(service.filterByTreinador(id));
    }
}
