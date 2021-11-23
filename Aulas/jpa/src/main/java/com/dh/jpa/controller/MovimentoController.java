package com.dh.jpa.controller;

import com.dh.jpa.persistence.entity.MovimentoEntity;
import com.dh.jpa.service.MovimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovimentoController {

    @Autowired
    private MovimentoService service;

    @GetMapping
    public ResponseEntity<List<MovimentoEntity>> all() {
        return ResponseEntity.ok(service.all());
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody MovimentoEntity m) {
        if(service.save(m) == null) {
            return ResponseEntity.badRequest().body("Ocorreu um erro");
        }

        return ResponseEntity.ok("Objeto salvo com sucesso");
    }
}
