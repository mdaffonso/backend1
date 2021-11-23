package com.dh.produtos.controller;

import com.dh.produtos.persistence.entity.ProductEntity;
import com.dh.produtos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductEntity>> all() {
        List<ProductEntity> all;
        try {
            all = service.all();
            return ResponseEntity.ok(all);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductEntity> one(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.one(id).get());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<ProductEntity> create(@RequestBody ProductEntity p) {
        try {
            ProductEntity created = service.save(p);
            return ResponseEntity.ok(created);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductEntity> edit(@RequestBody ProductEntity p) {
        Optional<ProductEntity> product = service.one(p.getId());
        if (product.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        p.setId(product.get().getId());
        try {
            return ResponseEntity.ok(p);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            service.delete(id);
            return ResponseEntity.ok("Produto deletado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Ocorreu um erro");
        }
    }
}
