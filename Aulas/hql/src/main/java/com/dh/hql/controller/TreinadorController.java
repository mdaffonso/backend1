package com.dh.hql.controller;

import com.dh.hql.model.Treinador;
import com.dh.hql.service.TreinadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("treinador")
public class TreinadorController {
    @Autowired
    private TreinadorService service;

    @PostMapping
    public ResponseEntity<Treinador> create(@RequestBody Treinador treinador) {
        return ResponseEntity.ok(service.create(treinador));
    }

    @GetMapping
    public ResponseEntity<List<Treinador>> all() {
        return ResponseEntity.ok(service.all());
    }
}
