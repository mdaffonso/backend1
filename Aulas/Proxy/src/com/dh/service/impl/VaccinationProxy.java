package com.dh.service.impl;

import com.dh.model.Person;
import com.dh.service.VaccinationInterface;

import java.util.Date;

public class VaccinationProxy implements VaccinationInterface {

    private VaccinationService vaccinationService;

    public VaccinationProxy(VaccinationService vaccinationService) {
        this.vaccinationService = vaccinationService;
    }

    @Override
    public void vaccinate(Person person) {
        Date currentDate = new Date();

        if(currentDate.before(person.getVaccinationDate())) {
            System.out.println("Você ainda não pode se vacinar. Confira a data da sua vacinação antes de tentar novamente.");
            return;
        }

        vaccinationService.vaccinate(person);
    }
}
