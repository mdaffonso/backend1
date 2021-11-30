package com.dh.hql.service;

import com.dh.hql.model.Treinador;
import com.dh.hql.repositories.TreinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreinadorService {
    @Autowired
    private TreinadorRepository repo;

    public Treinador create(Treinador treinador) {
        return repo.save(treinador);
    }

    public List<Treinador> all() {
        return repo.findAll();
    }
}
