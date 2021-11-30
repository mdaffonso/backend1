package com.dh.hql.service;

import com.dh.hql.model.Equipe;
import com.dh.hql.repositories.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository repo;

    public Equipe insert(Equipe equipe) {
        return repo.save(equipe);
    }

    public List<Equipe> all() {
        return repo.findAll();
    }
}
