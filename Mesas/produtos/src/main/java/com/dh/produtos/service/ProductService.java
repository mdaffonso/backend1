package com.dh.produtos.service;

import com.dh.produtos.persistence.entity.ProductEntity;
import com.dh.produtos.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository repo;

    public List<ProductEntity> all() {
        return repo.findAll();
    }

    public Optional<ProductEntity> one(Integer id) {
        return repo.findById(id);
    }

    public ProductEntity save(ProductEntity p) {
        return repo.save(p);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
