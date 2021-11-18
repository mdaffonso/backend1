package com.dh.clinic2.controller;

import com.dh.clinic2.model.Appointment;
import com.dh.clinic2.repository.AppointmentDAO;
import com.dh.clinic2.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("consulta")
public class AppointmentController {
    @Autowired
    private AppointmentService service;

    @GetMapping
    public ResponseEntity<Map<Integer, Appointment>> all() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.all());
    }

    @GetMapping("{id}")
    public ResponseEntity<Appointment> find(@PathVariable Integer id) {
        Appointment appointment = service.find(id);

        if(appointment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(appointment);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        return ResponseEntity.ok("Consulta excluída com sucesso.");
    }

    @PostMapping
    public ResponseEntity<Appointment> create(@RequestBody AppointmentDAO a) {
        Appointment appointment = service.create(a);
        if(appointment == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().body(appointment);
    }

    @PutMapping("{id}")
    public ResponseEntity<Appointment> edit(@PathVariable Integer id, @RequestBody Appointment a) {
        Appointment appointment = service.edit(id, a);
        if(appointment == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().body(appointment);
    }
}
