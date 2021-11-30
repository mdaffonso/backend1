package com.dh.hql.controller;

import com.dh.hql.model.Equipe;
import com.dh.hql.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("equipe")
public class EquipeController {
    @Autowired
    private EquipeService service;

    @PostMapping
    public ResponseEntity<Equipe> create(@RequestBody Equipe equipe) {
        return ResponseEntity.ok(service.insert(equipe));
    }

    @GetMapping
    public ResponseEntity<List<Equipe>> all() {
        return ResponseEntity.ok(service.all());
    }
}
