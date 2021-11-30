package com.dh.clinica.service;

import com.dh.clinica.persistence.entity.Dentist;
import com.dh.clinica.persistence.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistService {

    @Autowired
    DentistRepository repo;

    public List<Dentist> all() {
        return repo.findAll();
    }

    public Optional<Dentist> find(Integer id) {
        return repo.findById(id);
    }

    public Dentist save(Dentist d) {
        return repo.save(d);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
