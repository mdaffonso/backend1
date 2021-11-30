package com.dh.clinica.controller;

import com.dh.clinica.dao.PatientDAO;
import com.dh.clinica.persistence.entity.Patient;
import com.dh.clinica.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

@RestController
public class PatientController {

    private final Logger logger = Logger.getLogger(PatientController.class);

    @Autowired
    PatientService service;

    @GetMapping("patients")
    public ResponseEntity<List<Patient>> all() {
        try {
            logger.info("Usuário listou pacientes");
            return ResponseEntity.ok(service.all());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("patient/{id}")
    public ResponseEntity<Patient> find(@PathVariable Integer id) {
        try {
            logger.info("Usuário buscou paciente de id " + id);
            Optional<Patient> patient = service.find(id);
            if(patient.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(patient.get());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("patient/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            logger.info("Usuário tentou deletar paciente de id " + id);
            service.delete(id);
            return ResponseEntity.ok("Paciente deletado com sucesso.");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().body("Ocorreu um erro.");
        }
    }

    @PostMapping("patient")
    public ResponseEntity<Patient> create(@RequestBody PatientDAO p) {
        try {
            logger.info("Usuário tentou criar um novo registro de paciente");
            Patient patient = new Patient(
                    p.getName(),
                    p.getEmail()
            );
            return ResponseEntity.ok(service.save(patient));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("patient/{id}")
    public ResponseEntity<Patient> edit(@RequestBody PatientDAO p, @PathVariable Integer id) {
        try {
            logger.info("Usuário tentou editar os dados do paciente de id " + id);
            Optional<Patient> patient = service.find(id);
            if(patient.isPresent()) {
                patient.get().setName(p.getName());
                patient.get().setEmail(p.getEmail());
                return ResponseEntity.ok(service.save(patient.get()));
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
