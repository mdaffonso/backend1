package com.dh.service.impl;

import com.dh.model.Person;
import com.dh.service.VaccinationInterface;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VaccinationService implements VaccinationInterface {

    @Override
    public void vaccinate(Person person) {
        System.out.println(person.getFullName() + ", RG " + person.getRg() + ", tomou a vacina " + person.getVaccine() + " no dia " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
    }
}
