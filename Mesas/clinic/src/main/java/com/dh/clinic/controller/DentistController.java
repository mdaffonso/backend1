package com.dh.clinic.controller;

import com.dh.clinic.dao.DentistDAO;
import com.dh.clinic.domain.Dentist;
import com.dh.clinic.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("dentist")
public class DentistController {

    @Autowired
    private DentistService service;

    @GetMapping
    public Map<Integer, Dentist> all() {
        return service.all();
    }

    @GetMapping("{id}")
    public DentistDAO one(@PathVariable Integer id) {
        return service.one(id);
    }

    @PutMapping("{id}")
    public DentistDAO edit(@PathVariable Integer id, @RequestBody Dentist d) {
        return service.edit(id, d);
    }

    @PostMapping
    public DentistDAO create(@RequestBody DentistDAO d) {
        return service.create(d);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
