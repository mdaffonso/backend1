package com.dh.jpa.service;

import com.dh.jpa.persistence.entity.MovimentoEntity;
import com.dh.jpa.persistence.repository.MovimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentoService {
    @Autowired
    private MovimentoRepository repo;

    public List<MovimentoEntity> all() {
        return repo.findAll();
    }

    public String save(MovimentoEntity m) {
        if(repo.save(m) != null) {
            return "Movimento salvo";
        }
        return null;
    }

    public MovimentoEntity find(Integer id) {
        return repo.findById(id).get();
    }
}
