package com.dh.clinica.controller;

import com.dh.clinica.dao.DentistDAO;
import com.dh.clinica.persistence.entity.Dentist;
import com.dh.clinica.service.DentistService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DentistController {

    private final Logger logger = Logger.getLogger(DentistController.class);

    @Autowired
    DentistService service;

    @GetMapping("dentists")
    public ResponseEntity<List<Dentist>> all() {
        try {
            logger.info("Usuário listou dentistas");
            return ResponseEntity.ok(service.all());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("dentist/{id}")
    public ResponseEntity<Dentist> find(@PathVariable Integer id) {
        try {
            logger.info("Usuário buscou dentista de id " + id);
            Optional<Dentist> dentist = service.find(id);
            if(dentist.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(dentist.get());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("dentist/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            logger.info("Usuário tentou deletar dentista de id " + id);
            service.delete(id);
            return ResponseEntity.ok("Dentista deletado com sucesso.");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().body("Ocorreu um erro.");
        }
    }

    @PostMapping("dentist")
    public ResponseEntity<Dentist> create(@RequestBody DentistDAO d) {
        try {
            logger.info("Usuário tentou criar um novo registro de dentista");
            Dentist dentist = new Dentist(
                    d.getName(),
                    d.getRegistry()
            );
            return ResponseEntity.ok(service.save(dentist));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("dentist/{id}")
    public ResponseEntity<Dentist> edit(@RequestBody DentistDAO d, @PathVariable Integer id) {
        try {
            logger.info("Usuário tentou editar os dados do dentista de id " + id);
            Optional<Dentist> dentist = service.find(id);
            if(dentist.isPresent()) {
                dentist.get().setName(d.getName());
                dentist.get().setRegistry(d.getRegistry());
                return ResponseEntity.ok(service.save(dentist.get()));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
