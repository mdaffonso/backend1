package com.dh.clinica.service;

import com.dh.clinica.persistence.entity.Patient;
import com.dh.clinica.persistence.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    PatientRepository repo;

    public List<Patient> all() {
        return repo.findAll();
    }

    public Optional<Patient> find(Integer id) {
        return repo.findById(id);
    }

    public Patient save(Patient p) {
        return repo.save(p);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
